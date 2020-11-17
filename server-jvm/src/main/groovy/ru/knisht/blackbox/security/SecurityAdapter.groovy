package ru.knisht.blackbox.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.Authentication
import org.springframework.security.web.FilterChainProxy
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.security.web.context.SecurityContextPersistenceFilter
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter
import org.springframework.stereotype.Service
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import ru.knisht.blackbox.mvc.LoginController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private CookieFilter filter

    @Service
    private static class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

        @Override
        void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException {

            String sessionId = CookieFilter.extractAuthenticationCookie(request)
            if (sessionId != null) {
                LoginController.localDatabase.remove(sessionId)
            }
            response.setStatus(HttpServletResponse.SC_OK)
            response.getWriter().flush()
        }
    }

    CustomLogoutSuccessHandler handler = new CustomLogoutSuccessHandler()

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return { throw new AuthenticationServiceException("Cannot authenticate " + it) }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
                .cors().and()
                .csrf { it.disable() }
                .logout {
                    it.addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL)))
                    it.logoutSuccessHandler(handler)
                    it.deleteCookies(CookieFilter.COOKIE_NAME)
                }
                .addFilterAfter(filter, SecurityContextPersistenceFilter.class)
    }
}

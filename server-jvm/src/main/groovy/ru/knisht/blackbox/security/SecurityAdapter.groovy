package ru.knisht.blackbox.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler
import org.springframework.security.web.context.SecurityContextPersistenceFilter
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private CookieFilter filter

    @Autowired
    CustomLogoutSuccessHandler handler

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

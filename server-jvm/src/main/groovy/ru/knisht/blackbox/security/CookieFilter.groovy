package ru.knisht.blackbox.security


import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.filter.GenericFilterBean
import ru.knisht.blackbox.mvc.LoginController

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import java.util.concurrent.ConcurrentHashMap

@Service
class CookieFilter extends GenericFilterBean {

    public final static String COOKIE_NAME = "authentication"

    private final ConcurrentHashMap<String, UserDetail> userDetailsCache

    CookieFilter() {
        this.userDetailsCache = new ConcurrentHashMap<>()
    }

    @Override
    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                  FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest

        String sessionId = extractAuthenticationCookie(httpServletRequest)

        if (sessionId != null) {
            UserDetail userDetails = LoginController.localDatabase.get(sessionId)

            if (userDetails != null) {
                SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(userDetails))
            }
        }

        filterChain.doFilter(servletRequest, servletResponse)
    }

    static String extractAuthenticationCookie(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies()
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName() == COOKIE_NAME) {
                    return cookie.getValue()
                }
            }
        }
        return null
    }
}

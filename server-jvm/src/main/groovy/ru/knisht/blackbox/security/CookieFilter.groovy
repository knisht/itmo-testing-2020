package ru.knisht.blackbox.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.filter.GenericFilterBean
import ru.knisht.blackbox.dao.SessionRepository
import ru.knisht.blackbox.model.Session

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest

@Service
class CookieFilter extends GenericFilterBean {

    public final static String COOKIE_NAME = "authentication"

    @Autowired
    private SessionRepository sessionRepository

    @Override
    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                  FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest

        String sessionId = extractAuthenticationCookie(httpServletRequest)

        if (sessionId != null) {
            Optional<Session> session = sessionRepository.findById(sessionId)

            if (session.isPresent()) {
                SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(session.get().userId))
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

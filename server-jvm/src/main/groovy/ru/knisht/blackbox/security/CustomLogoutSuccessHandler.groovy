package ru.knisht.blackbox.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.stereotype.Service
import ru.knisht.blackbox.dao.SessionRepository

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    SessionRepository sessionRepository

    @Override
    void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                         Authentication authentication) throws IOException {

        String sessionId = CookieFilter.extractAuthenticationCookie(request)
        if (sessionId != null) {
            sessionRepository.deleteById(sessionId)
        }
        response.setStatus(HttpServletResponse.SC_OK)
        response.getWriter().flush()
    }
}

package ru.knisht.blackbox.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.knisht.blackbox.dao.SessionRepository
import ru.knisht.blackbox.dao.UserRepository
import ru.knisht.blackbox.model.Session
import ru.knisht.blackbox.security.CookieFilter
import ru.knisht.blackbox.security.TokenService

@RestController
@CrossOrigin(allowCredentials = "true", origins = ['http://localhost:8080'])
@Newify(pattern = /[A-Z].*]/)
class LoginController {

    @Autowired
    private TokenService tokenService

    @Autowired
    private UserRepository userRepository

    @Autowired
    private SessionRepository sessionRepository

    @GetMapping("/logged")
    @PreAuthorize('isFullyAuthenticated()')
    String logged(@AuthenticationPrincipal Long id) {
        (id != null).toString()
    }

    @PostMapping("/logout")
    void logout() {}

    @PostMapping("/login")
    ResponseEntity<String> login(String username, String password) {
        def user = userRepository.findByNameAndPassword username, password
        if (user != null) {
            def sessionToken = tokenService.createToken()

            def cookie = ResponseCookie
                    .from(CookieFilter.COOKIE_NAME, sessionToken)
                    .maxAge(3600)
                    .sameSite('Strict')
                    .httpOnly(true).secure(false).build()

            sessionRepository.save new Session(id: sessionToken, userId: user.userId)
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body('true')
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }
}

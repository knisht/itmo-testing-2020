package ru.knisht.blackbox.mvc


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
import ru.knisht.blackbox.security.CookieFilter
import ru.knisht.blackbox.security.TokenService
import ru.knisht.blackbox.security.UserDetail

import java.util.concurrent.ConcurrentHashMap

@RestController
@CrossOrigin(allowCredentials = "true", origins = ['http://localhost:8080'])
class LoginController {

    @Autowired
    private TokenService tokenService

    static ConcurrentHashMap<String, UserDetail> localDatabase = new ConcurrentHashMap<>()

    @GetMapping("/logged")
    @PreAuthorize('isFullyAuthenticated()')
    String logged(@AuthenticationPrincipal UserDetail bean) {
        (bean != null).toString()
    }

    @PostMapping("/logout")
    void logout() {}

    @PostMapping("/login")
    ResponseEntity<String> login(String username, String password) {
        if (username == 'admin' && password == 'admin') {
            def sessionToken = tokenService.createToken()

            def cookie = ResponseCookie
                    .from(CookieFilter.COOKIE_NAME, sessionToken)
                    .maxAge(3600)
                    .sameSite('Strict')
                    .httpOnly(true).secure(false).build()
            def detail = new UserDetail(username, password, Collections.emptySet())
            localDatabase.put(sessionToken, detail)
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body('true')
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }
}

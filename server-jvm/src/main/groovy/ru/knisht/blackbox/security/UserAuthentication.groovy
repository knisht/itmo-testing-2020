package ru.knisht.blackbox.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

class UserAuthentication implements Authentication {

    private final Long userId

    UserAuthentication(Long userId) {
        this.userId = userId
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return null
    }

    Object credentials = null

    Object details = null

    Long principal = userId

    boolean authenticated = true

    @Override
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new UnsupportedOperationException('always authenticated')
    }

    String name = null
}

package ru.knisht.blackbox.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

class UserAuthentication implements Authentication {

    private static final long serialVersionUID = 1L

    private final UserDetail detail

    UserAuthentication(UserDetail detail) {
        this.detail = detail
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return null
    }

    Object credentials = null

    Object details = null

    UserDetail principal = detail

    boolean authenticated = true

    @Override
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new UnsupportedOperationException('always authenticated')
    }

    String name = detail.username
}

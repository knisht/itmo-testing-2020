package ru.knisht.blackbox.security


import groovy.transform.TupleConstructor
import org.springframework.security.core.GrantedAuthority

@TupleConstructor(defaults = false)
class UserDetail {
    String username
    String password
    Set<GrantedAuthority> authorities
}

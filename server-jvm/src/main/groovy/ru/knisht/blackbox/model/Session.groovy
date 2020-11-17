package ru.knisht.blackbox.model

import groovy.transform.MapConstructor

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'sessions')
@MapConstructor(noArg = true)
class Session {
    @Id
    @Column(name = 'id')
    String id

    @Column(name = 'userid')
    Long userId
}

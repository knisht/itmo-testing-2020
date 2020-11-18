package ru.knisht.blackbox.model

import groovy.transform.ToString
import groovy.transform.TupleConstructor

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name='users')
@ToString
@TupleConstructor
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid")
    Long userId

    @Column(name='name')
    String name

    @Column(name='password')
    String password
}

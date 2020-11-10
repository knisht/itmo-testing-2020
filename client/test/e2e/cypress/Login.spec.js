/// <reference types="cypress" />

context('Login tests', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080/login')
    })

    it('Wrong login and password', () => {
        cy.get('#username-input').type("abcde")
        cy.get('#password-input').type("defghi")
        cy.get('#login-button').click()
        cy.get('#failure-message').should('be.visible')
    })

    it('Empty login', () => {
        cy.get('#password-input').type("defghi")
        cy.get('#login-button').click()
        cy.get('#failure-message').should('be.visible')
    })

    it('Correct password but wring login', () => {
        cy.get("#username-input").type("asdasdasd")
        cy.get('#password-input').type("admin")
        cy.get('#login-button').click()
        cy.get('#failure-message').should('be.visible')
    })
})

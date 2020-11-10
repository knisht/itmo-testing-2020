/// <reference types="cypress" />

context('Navigation tests', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080/')
    })

    it('Switch page and return', () => {
        cy.get('a').contains('Guess').click()
        cy.get('a').contains('Home').click()
        cy.get('.conversation').should('be.visible')
    })
})

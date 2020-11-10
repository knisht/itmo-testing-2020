/// <reference types="cypress" />

context('Guessing game tests', () => {

    it('Typing wrong answer', () => {
        cy.visit('http://localhost:8080/guess')
        cy.get('#input_form')
            .type('1234561').should('have.value', '1234561')

        cy.get('#incorrect_answer').should('be.visible')
    })

})

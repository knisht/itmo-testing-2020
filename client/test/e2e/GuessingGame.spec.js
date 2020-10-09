/// <reference types="cypress" />

context('Actions', () => {
    beforeEach(() => {
        cy.visit('http://localhost:8080/guess')
    })


    it('Typing wrong answer', () => {
        cy.get('#input_form')
            .type('1234561').should('have.value', '1234561')

        cy.get('#incorrect_answer').should('be.visible')
    })
})

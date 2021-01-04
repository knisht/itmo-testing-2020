package ru.knisht.blackbox.unit

import org.junit.Assert
import org.junit.ClassRule
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import ru.knisht.blackbox.controllers.LoginController
import ru.knisht.blackbox.dao.UserRepository
import ru.knisht.blackbox.model.User

@SpringBootTest
@ContextConfiguration(initializers = Initializer)
@Testcontainers
class LoginTests {

	@Autowired
	UserRepository userRepository

	@Autowired
	LoginController loginController

	@ClassRule
	@Container
	static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer('postgres:11.1')
			.withDatabaseName("integration-tests-db")
			.withUsername('admeen')
			.withPassword('admeen')

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues.of(
					"spring.datasource.url=${postgreSQLContainer.jdbcUrl}",
					"spring.datasource.username=${postgreSQLContainer.username}",
					"spring.datasource.password=${postgreSQLContainer.password}"
			).applyTo(configurableApplicationContext.environment)
		}
	}

	@Test
	@Transactional
	void 'successful authorization'() {
		def username = 'hello', password = 'world'
		userRepository.save new User(name: username, password: password)
		Assert.assertEquals(loginController.login(username, password).statusCode, HttpStatus.OK)
	}

}

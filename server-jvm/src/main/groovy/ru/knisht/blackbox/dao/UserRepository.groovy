package ru.knisht.blackbox.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.knisht.blackbox.model.User

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    User findByNameAndPassword(String username, String password)
}

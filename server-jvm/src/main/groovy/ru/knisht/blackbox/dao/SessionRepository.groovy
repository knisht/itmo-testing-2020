package ru.knisht.blackbox.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.knisht.blackbox.model.Session

@Repository
interface SessionRepository extends CrudRepository<Session, String> {
}

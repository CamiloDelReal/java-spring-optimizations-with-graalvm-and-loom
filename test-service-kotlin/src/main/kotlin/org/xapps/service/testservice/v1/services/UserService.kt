package org.xapps.service.testservice.v1.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.xapps.service.testservice.v1.entities.User
import org.xapps.service.testservice.v1.repositories.UserRepository

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun readAllUsers(): List<User> =
        userRepository.findAll()

}
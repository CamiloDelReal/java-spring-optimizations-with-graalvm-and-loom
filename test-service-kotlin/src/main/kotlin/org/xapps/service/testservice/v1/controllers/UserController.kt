package org.xapps.service.testservice.v1.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.xapps.service.testservice.v1.entities.User
import org.xapps.service.testservice.v1.services.UserService

@RestController
@RequestMapping(path = ["/users"])
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun readAllUsers(): ResponseEntity<List<User>> =
        ResponseEntity.ok(userService.readAllUsers())

}
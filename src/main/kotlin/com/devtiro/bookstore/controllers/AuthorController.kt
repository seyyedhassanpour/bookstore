package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.domain.AuthorEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController {

    @PostMapping(path=["v1/authors"])
    fun createAuthor(@RequestBody authorEntity: AuthorEntity) {
        // Create author
    }
}
package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.dto.AuthorDto
import com.devtiro.bookstore.services.AuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import toAuthorDto
import toAuthorEntity

@RestController
class AuthorController(private val authorService: AuthorService) {

    @PostMapping(path = ["v1/authors"])
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {

        val createdAuthor = authorService.save(
            authorDto.toAuthorEntity()
        )
            .toAuthorDto()
        return ResponseEntity(createdAuthor, HttpStatus.CREATED)
    }
}
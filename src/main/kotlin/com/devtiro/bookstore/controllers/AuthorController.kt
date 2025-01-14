package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.dto.AuthorDto
import com.devtiro.bookstore.services.AuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import toAuthorDto
import toAuthorEntity

@RestController
@RequestMapping(path = ["v1/authors"])
class AuthorController(private val authorService: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {

        val createdAuthor = authorService.save(
            authorDto.toAuthorEntity()
        )
            .toAuthorDto()
        return ResponseEntity(createdAuthor, HttpStatus.CREATED)
    }

    @GetMapping
    fun readManyAuthors(): ResponseEntity<List<AuthorDto>> = authorService.list()
        .map { it.toAuthorDto() }
        .let { ResponseEntity(it, HttpStatus.OK) }


}
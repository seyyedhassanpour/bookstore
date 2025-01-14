package com.devtiro.bookstore.services

import com.devtiro.bookstore.domain.AuthorEntity

interface AuthorService {
    fun save(authorEntity: AuthorEntity): AuthorEntity
    fun list(): List<AuthorEntity>
}
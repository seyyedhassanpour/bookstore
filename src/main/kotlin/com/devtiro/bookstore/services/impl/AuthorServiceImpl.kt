package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.domain.AuthorEntity
import com.devtiro.bookstore.repositories.entities.AuthorRepository
import com.devtiro.bookstore.services.AuthorService
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository):AuthorService {
    override fun save(authorEntity: AuthorEntity): AuthorEntity {
        return authorRepository.save(authorEntity)
    }
}
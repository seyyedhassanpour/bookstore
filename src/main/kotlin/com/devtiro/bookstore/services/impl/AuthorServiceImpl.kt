package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.domain.entities.AuthorEntity
import com.devtiro.bookstore.repositories.AuthorRepository
import com.devtiro.bookstore.services.AuthorService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {
    override fun save(authorEntity: AuthorEntity): AuthorEntity =
        authorRepository.save(authorEntity)


    override fun list(): List<AuthorEntity> = authorRepository.findAll()
    override fun get(id: Long): AuthorEntity? = authorRepository.findByIdOrNull(id)
}
package com.devtiro.bookstore.repositories.entities

import com.devtiro.bookstore.domain.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<AuthorEntity,Long?>
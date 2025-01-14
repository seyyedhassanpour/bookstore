package com.devtiro.bookstore.repositories.entities

import com.devtiro.bookstore.domain.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<BookEntity, String>

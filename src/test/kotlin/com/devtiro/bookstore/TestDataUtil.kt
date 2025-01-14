package com.devtiro.bookstore

import com.devtiro.bookstore.domain.entities.AuthorEntity
import com.devtiro.bookstore.dto.AuthorDto

fun testAuthorDtoA(id: Long? = null) = AuthorDto(
    id = id,
    name = "John Doe",
    age = 45,
    image = "https://example",
    description = "A description"
)

fun testAuthorEntityA(id: Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 45,
    image = "https://example",
    description = "A description"
)
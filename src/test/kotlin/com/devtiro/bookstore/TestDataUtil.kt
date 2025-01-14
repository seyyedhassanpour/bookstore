package com.devtiro.bookstore

import com.devtiro.bookstore.dto.AuthorDto

fun testAuthorDtoA(id: Long? = null) = AuthorDto(
    id = null,
    name = "John Doe",
    age = 45,
    image = "https://example",
    description = "A description"
)
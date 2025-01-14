package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.dto.AuthorDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class AuthorsControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    val objectMapper = ObjectMapper()

    @Test
    fun `test that create author returns a http 201 status on a successful create`() {
        mockMvc.post("/v1/authors") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                (
                        AuthorDto(
                            id = null,
                            name = "John Doe",
                            age = 45,
                            image = "https://example",
                            description = "A description"

                        )
                        )
            )
        }.andExpect {
            status { isCreated() }
        }
    }

}
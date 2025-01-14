package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.repositories.entities.AuthorRepository
import com.devtiro.bookstore.testAuthorEntityA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class AuthorServiceImplTest @Autowired constructor(private val underTest: AuthorServiceImpl) {

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun `test that save persist author in the DB - integration test`() {
        val savedAuthor = underTest.save(testAuthorEntityA())
        assertThat(savedAuthor.id).isNotNull()

        val recalledAuthor = authorRepository.findByIdOrNull(savedAuthor.id!!)
        assertThat(recalledAuthor).isNotNull()
        assertThat(recalledAuthor!!).isEqualTo(testAuthorEntityA(id = savedAuthor.id))
    }
}
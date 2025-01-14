package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.repositories.AuthorRepository
import com.devtiro.bookstore.testAuthorEntityA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class AuthorServiceImplTest @Autowired constructor(
    private val authorServiceImplementation: AuthorServiceImpl,
    private val authorRepository: AuthorRepository
) {

    @Test
    fun `test that save persists the Author in the database`() {
        val savedAuthor = authorServiceImplementation.save(testAuthorEntityA())
        assertThat(savedAuthor.id).isNotNull()

        val recalledAuthor = authorRepository.findByIdOrNull(savedAuthor.id!!)
        assertThat(recalledAuthor).isNotNull()
        assertThat(recalledAuthor!!).isEqualTo(
            testAuthorEntityA(id = savedAuthor.id)
        )
    }


    @Test
    fun `test that list returns empty list when no authors in the database`() {
        val result = authorServiceImplementation.list()
        assertThat(result).isEmpty()
    }

    // For unknown reasons, the test below fails. it is identical to the previous one
//    @Test
//    fun `test that list returns empty list when authors are not present`() {
//        val result = underTest.list()
//        assertThat(result).isEmpty()
//    }

    @Test
    fun `test that list returns authors when authors present in the database`() {
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        val expected = listOf(savedAuthor)
        val result = authorServiceImplementation.list()
        assertThat(result).isEqualTo(expected)
    }


    @Test
//    fun `test that get returns null when author not found`() {
    fun `test that get returns null when author not present in the database`() {
        val result = authorServiceImplementation.get(999)
        assertThat(result).isNull()
    }

    @Test
//    fun `test that get returns author when author found`() {
    fun `test that get returns author when author is present in the database`() {
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        val result = authorServiceImplementation.get(savedAuthor.id!!)
        assertThat(result).isEqualTo(savedAuthor)
    }

}
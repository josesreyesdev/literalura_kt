package com.jsrdev.literalura.repository

import com.jsrdev.literalura.model.local.Author
import com.jsrdev.literalura.model.local.Book
import com.jsrdev.literalura.model.local.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BookRepository: JpaRepository<Book, Long> {

    @Query("SELECT a FROM Book AS b JOIN b.authors AS a WHERE a.role = :role")
    fun findAuthorsByRole(role: Role): List<Author>

    @Query("SELECT DISTINCT a FROM Book AS b JOIN b.authors AS a WHERE a.birthYear = :entryBirthYear")
    fun findAuthorsInABirthYear(entryBirthYear: Int): List<Author>

    @Query("SELECT b FROM Book b WHERE :language MEMBER OF b.languages")
    fun findBookByLanguage(language: String): List<Book>

}
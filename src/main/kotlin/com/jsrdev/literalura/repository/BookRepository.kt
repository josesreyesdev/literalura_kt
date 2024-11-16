package com.jsrdev.literalura.repository

import com.jsrdev.literalura.model.local.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Long>
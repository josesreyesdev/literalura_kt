package com.jsrdev.literalura.model.mappers

import com.jsrdev.literalura.model.local.Author
import com.jsrdev.literalura.model.local.Book
import com.jsrdev.literalura.model.network.AuthorData
import com.jsrdev.literalura.model.network.BookData

fun BookData.toBook(): Book {
    val book = Book(
        id = id,
        title = title,
        authors = mutableListOf(),
        translators = mutableListOf(),
        subjects = subjects,
        bookshelves = bookshelves,
        languages = languages,
        copyright = copyright,
        mediaType = mediaType,
        downloadCount = downloadCount
    )

    book.authors.addAll(authors.map { it.toAuthor(book) })
    book.translators?.addAll(translators?.map { it.toAuthor(book) } ?: emptyList())

    return book
}

fun AuthorData.toAuthor(book: Book): Author =
    Author(
        name = name,
        birthYear = birthYear,
        deathYear = deathYear,
        book = book
    )
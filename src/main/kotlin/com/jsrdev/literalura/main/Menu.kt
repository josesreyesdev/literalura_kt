package com.jsrdev.literalura.main

import com.jsrdev.literalura.constants.Constants
import com.jsrdev.literalura.model.local.Book
import com.jsrdev.literalura.model.mappers.toBook
import com.jsrdev.literalura.model.network.BookData
import com.jsrdev.literalura.model.network.ResponseData
import com.jsrdev.literalura.repository.BookRepository
import com.jsrdev.literalura.service.ConvertData
import com.jsrdev.literalura.service.GetBookData
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class Menu(
    private val repository: BookRepository,
    private val apiService: GetBookData = GetBookData(),
    private val deserializedData: ConvertData = ConvertData()
) {
    fun showMenu() {
        while (true) {
            var option: Int? = entryOption()
            while (option == null) {
                option = invalidOption()
            }

            when (option) {
                1 -> bookData()
                2 -> registeredBooks()
                3 -> {}
                4 -> {}
                5 -> {}
                0 -> {
                    println("********** GOOD BYE **********")
                    break
                }
                else -> invalidOption()
            }
        }
    }

    private fun entryOption(): Int? {
        /**alive = vivos */
        println("\nOptions:")
        val menu = """
            1.- Search books by title from API
            2.- Registered books
            3.- Registered authors
            4.- Authors alive in a given year
            5.- Books by language
            
            0.- Exit
        """.trimIndent()
        println(menu)
        println("\nEnter the option: ")
        return readln().toIntOrNull()
    }

    private fun invalidOption(): Int? {
        println("\nInvalid entry, please, try again")
        return entryOption()
    }

    private fun bookData() {
        val bookData: List<BookData> = getResponseData().results
        bookData.forEach {
            val book: Book = it.toBook()
            repository.save(book)
            printBook(book)
        }
    }

    private fun registeredBooks() {
        val books: MutableList<Book> = repository.findAll()
        books.forEach { printBook(it) }
    }

    private fun printBook(book: Book) {
        println("\n----------Book----------")
        println("Title: ${book.title}")
        book.authors.forEachIndexed {i, a -> println("Author ${i+1}.- ${a.name}") }
        book.languages.forEachIndexed {i, l -> println("Language ${i+1}.- $l") }
        println("Download count: ${book.downloadCount}")
        println("------------------------")
    }

    /* ************* FETCH DATA *************** */
    private fun getResponseData(): ResponseData {
        var bookTitle: String? = enterTitle()
        while (bookTitle.isNullOrEmpty()) {
            println("\nInvalid entry, please, try again")
            bookTitle = enterTitle()
        }
        bookTitle = bookTitle.trim().lowercase()

        val title = encodedBookTitle(bookTitle)
        val buildURL: String = buildURL(title)
        val json: String = apiService.fetchData(buildURL)
        println("Response: $json")

        return deserializedData.getData(json, ResponseData::class.java)
    }

    private fun enterTitle(): String? {
        println("\nEnter the book title: ")
        return readlnOrNull()
    }

    private fun encodedBookTitle(bookTitle: String): String =
        URLEncoder.encode(bookTitle, StandardCharsets.UTF_8)

    private fun buildURL(title: String): String {
        val baseURL = Constants.BASE_URL
        val urlBuilder: StringBuilder = StringBuilder(baseURL)
        return urlBuilder.append("books/?search=").append(title).toString()
    }
}
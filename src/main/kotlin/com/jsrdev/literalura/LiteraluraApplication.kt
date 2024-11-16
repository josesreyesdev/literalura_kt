package com.jsrdev.literalura

import com.jsrdev.literalura.main.Menu
import com.jsrdev.literalura.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiteraluraApplication @Autowired constructor(private val repository: BookRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        Menu(repository = repository).showMenu()
    }
}

fun main(args: Array<String>) {
    runApplication<LiteraluraApplication>(*args)
}

package com.jsrdev.literalura

import com.jsrdev.literalura.main.Menu
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiteraluraApplication: CommandLineRunner {
    override fun run(vararg args: String?) {
        Menu().showMenu()
    }
}

fun main(args: Array<String>) {
    runApplication<LiteraluraApplication>(*args)
}

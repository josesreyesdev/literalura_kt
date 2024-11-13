package com.jsrdev.literalura.main

class Menu {

    fun showMenu() {
        while (true) {
            var option: Int? = entryOption()
            while (option == null) {
                option = invalidOption()
            }

            when (option) {
                1 -> {}
                2 -> {}
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
        val menu = """
            1.- Search books by title
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
}
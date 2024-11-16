package com.jsrdev.literalura.model.local

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "authors")
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @Column(name = "birth_year")
    val birthYear: Int,
    @Column(name = "death_year")
    val deathYear: Int,
    @ManyToOne
    val book: Book
)

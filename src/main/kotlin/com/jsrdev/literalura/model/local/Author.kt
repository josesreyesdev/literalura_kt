package com.jsrdev.literalura.model.local

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @Column(name = "birth_year")
    val birthYear: Int,
    @Column(name = "death_year")
    val deathYear: Int,
    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val role: Role
) {
    override fun toString(): String {
        return "Author(id=$id, name='$name', birthYear=$birthYear, deathYear=$deathYear, bookId=${book.id}, role=$role)"
    }
}

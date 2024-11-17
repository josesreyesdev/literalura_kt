package com.jsrdev.literalura.model.local

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id @Column(unique = true, nullable = false)
    val id: Long,
    val title: String,
    @OneToMany(mappedBy = "book", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val authors: MutableList<Author>,
    @OneToMany(mappedBy = "book", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val translators: MutableList<Author>?,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "subjects",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")]
    )
    val subjects: List<String>,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "book_shelves",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")]
    )
    @Column(name = "book_shelves")
    val bookshelves: List<String>,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "languages",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")]
    )
    val languages: List<String>,
    val copyright: Boolean,
    @Column(name = "media_type")
    val mediaType: String,
    @Column(name = "download_count")
    val downloadCount: Int
) {
    override fun toString(): String {
        return "Book(id=$id, title='$title', authors=$authors, translators=$translators, subjects=$subjects, bookshelves=$bookshelves, languages=$languages, copyright=$copyright, mediaType='$mediaType', downloadCount=$downloadCount)"
    }
}

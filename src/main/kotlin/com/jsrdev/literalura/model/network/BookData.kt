package com.jsrdev.literalura.model.network

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BookData(
    @JsonAlias("id") val id: Long,
    @JsonAlias("title") val title: String,
    @JsonAlias("authors") val authors: List<AuthorData>,
    @JsonAlias("translators") val translators: List<AuthorData>?,
    @JsonAlias("subjects") val subjects: List<String>,
    @JsonAlias("bookshelves") val bookshelves: List<String>,
    @JsonAlias("languages") val languages: List<String>,
    @JsonAlias("copyright") val copyright: Boolean,
    @JsonAlias("media_type") val mediaType: String,
    @JsonAlias("download_count") val downloadCount: Int
)

package com.jsrdev.literalura.model.network

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AuthorData(
    @JsonAlias("name") val name: String,
    @JsonAlias("birth_year") val birthYear: Int,
    @JsonAlias("death_year") val deathYear: Int
)

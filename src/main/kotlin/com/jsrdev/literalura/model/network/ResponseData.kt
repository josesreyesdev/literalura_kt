package com.jsrdev.literalura.model.network

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseData(
    @JsonAlias("count") val count: Long,
    @JsonAlias("next") val next: String?,
    @JsonAlias("previous") val previous: String?,
    @JsonAlias("results") val results: List<BookData>
)

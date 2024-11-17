package com.jsrdev.literalura.service

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.IOException

class ConvertData : IConvertData {

    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    override fun <T> getData(json: String, genericClass: Class<T>): T = try {
        objectMapper.readValue(json, genericClass)
    } catch (ex: JsonProcessingException) {
        throw RuntimeException("Error processing JSON: ${ex.message}", ex)
    } catch (ex: IOException) {
        throw RuntimeException("Error reading input data: ${ex.message}", ex)
    }
}

package com.jsrdev.literalura.service

import com.jsrdev.literalura.model.network.ResponseData
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GetBookData : ApiService {
    override fun fetchData(url: String): String {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        return try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofString())
            if (response.statusCode() != 200) {
                throw RuntimeException("Error: Received status code ${response.statusCode()} from API")
            }

            if (response.body().isNullOrEmpty()) {
                throw IllegalArgumentException("Received an empty or null JSON string.")
            }

            response.body()
        } catch (ex: IOException) {
            throw RuntimeException("Network error while making the API request: ${ex.message}", ex)
        } catch (ex: InterruptedException) {
            Thread.currentThread().interrupt()
            throw RuntimeException("Request interrupted: ${ex.message}", ex)
        }
    }
}
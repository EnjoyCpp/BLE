package com.dinkar.blescanner

import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {

    val objectMapper = ObjectMapper()
    val requestBody: String = objectMapper
        .writeValueAsString(values)

    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://httpbin.org/post"))
        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    println(response.body())
}
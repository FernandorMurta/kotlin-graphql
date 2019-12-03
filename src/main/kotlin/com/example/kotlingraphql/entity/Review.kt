package com.example.kotlingraphql.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "reviews")
data class Review(
        var snackId: String,
        var rating: Int,
        var text: String
)
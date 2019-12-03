package com.example.kotlingraphql.repository

import com.example.kotlingraphql.entity.Review
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : MongoRepository<Review, String> {
}
package com.example.kotlingraphql.repository

import com.example.kotlingraphql.entity.Snack
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SnackRepository : MongoRepository<Snack, String>
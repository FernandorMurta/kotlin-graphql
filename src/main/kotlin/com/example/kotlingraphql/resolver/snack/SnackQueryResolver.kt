package com.example.kotlingraphql.resolver.snack

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.kotlingraphql.entity.Review
import com.example.kotlingraphql.entity.Snack
import com.example.kotlingraphql.repository.SnackRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver(val snackRepository: SnackRepository,
                         private val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun snacks(): List<Snack> {
        val list = snackRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(item.id)
        }

        return list
    }

    fun totalAmount(): Float {
        val list: List<Snack> = snackRepository.findAll()

        return list.map { it.amount }.sum();
    }

    private fun getReviews(snackId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }
}
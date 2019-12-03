package com.example.kotlingraphql.resolver.review

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.kotlingraphql.entity.Review
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component


@Component
class ReviewQueryResolver(private val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun reviews(snackId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }

}
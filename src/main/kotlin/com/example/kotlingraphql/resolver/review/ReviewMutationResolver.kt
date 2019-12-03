package com.example.kotlingraphql.resolver.review

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.kotlingraphql.entity.Review
import com.example.kotlingraphql.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewMutationResolver(val reviewRepository: ReviewRepository) : GraphQLMutationResolver {

    fun newReview(snackId: String, rating: Int, text: String): Review {
        val review = Review(snackId, rating, text)
        return reviewRepository.save(review)
    }
}

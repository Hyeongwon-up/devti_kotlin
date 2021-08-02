package hw.devti.domain.review.service

import hw.devti.domain.review.dao.ReviewRepository
import hw.devti.domain.review.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository
) {

    fun findByReviewType(reviewType: String): Review {
        return reviewRepository.findReviewByReviewType(reviewType)
    }


}
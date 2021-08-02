package hw.devti.domain.review.dao

import hw.devti.domain.review.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {

    fun findReviewByReviewType(reviewType: String): Review
}
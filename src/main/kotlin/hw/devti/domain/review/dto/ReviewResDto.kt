package hw.devti.domain.review.dto

import hw.devti.domain.review.entity.Review
import javax.persistence.Column
import javax.persistence.Lob

data class ReviewResDto(

    @Column(length = 500)
    var title: String?,

    @Lob
    @Column(length = 500)
    var contents: String?,

    ) {

    companion object {
        fun toResDto(review: Review): ReviewResDto {
            return review.run {
                ReviewResDto(title = review.title, contents = review.contents)
            }
        }
    }
}

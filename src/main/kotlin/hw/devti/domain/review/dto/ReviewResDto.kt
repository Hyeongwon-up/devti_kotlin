package hw.devti.domain.review.dto

import javax.persistence.Column
import javax.persistence.Lob

data class ReviewResDto(

    @Column(length = 500)
    var title: String?,

    @Lob
    @Column(length = 500)
    var contents: String?,

)

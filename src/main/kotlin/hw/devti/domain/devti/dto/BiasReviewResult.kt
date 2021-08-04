package hw.devti.domain.devti.dto

import hw.devti.domain.bias.entity.Bias
import hw.devti.domain.review.dto.ReviewResDto
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class BiasReviewResult(

    @ApiModelProperty(value = "Bias 정보")
    var bias: Bias?,

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Bias percent", example = "10")
    var weight: Int?,

    @ApiModelProperty(value = "Bias 총평", example = "필러 총평")
    val review: ReviewResDto?

    )


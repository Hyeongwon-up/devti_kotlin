package hw.devti.domain.devti.dto

import com.sun.istack.NotNull
import io.swagger.annotations.ApiModelProperty

data class DevtiReqDto(

    @ApiModelProperty(value = "희망 직무 (F,B)", example = "F")
    private var job: String,

    @ApiModelProperty(value = "DEVTI 결과 HashMap String", example = "{W=90, A=60, P=60, V=35, T=40, S=75, L=0, C=15}")
    private val result: String

)

data class DevtiResDto(

    @ApiModelProperty(value = "DEVTI 16타입", example = "VPSW")
    private var devti: String,

    @ApiModelProperty(value = "DEVTI 제목", example = "열정적인 꿈을 가진 당신은 야망가!")
    private val devtiTitle: String,

    @ApiModelProperty(value = "DEVTI 총평", example = "당신은 블라블라해요 블라블라하면 블라블라해서 블라블라 할수있을거에요 블라블라~~")
    private val generalReview: @javax.validation.constraints.NotNull ReviewResDto? = null

    @ApiModelProperty(value = "Bias 결과 리스트 ")
    private val biasResults: List<BiasReviewResult>

    @ApiModelProperty(value = "학습, 채용공고")
    private val advertisementList: List<Advertisement>? = null

)
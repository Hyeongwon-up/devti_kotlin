package hw.devti.domain.survey.dto

import hw.devti.domain.survey.entity.Survey
import hw.devti.global.code.SurveyType
import hw.devti.global.code.TestType
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

data class SurveyPostReqDto(

    @NotBlank(message = "SurveyType을 입력하세요. (ex. DEVTI)")
    @ApiModelProperty(value = "사전 참여 조사 타입(현재는 DEVTI만 존재)", example = "DEVTI")
    var surveyType: SurveyType,

    @ApiModelProperty(value = "사전 참여 조사 comment", example = "FE, BE그것이 문제로다")
    var comment: String,

    @ApiModelProperty(value = "이메일", example = "abc@devti.com")
    var email: String,

    @ApiModelProperty(value = "휴대폰 번호", example = "010-9594-8215")
    var phone: String,

    @ApiModelProperty(value = "Bucket test type", example = "TYPE_COMMON_1")
    var testType: TestType

)

data class SurveyPostResDto(

    var id: Long?,
    var comment: String,
    var email: String,
    var phone: String,
    var testType: TestType
){

    companion object {
        fun toResDto(survey: Survey): SurveyPostResDto {
            return survey.run {
                SurveyPostResDto(id, comment, email, phone, testType)
            }
        }
    }
}
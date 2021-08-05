package hw.devti.domain.survey.api

import hw.devti.domain.survey.dto.SurveyPostReqDto
import hw.devti.domain.survey.dto.SurveyPostResDto
import hw.devti.domain.survey.service.SurveyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/survey")
@Api(value = "Survey")
class SurveyController(
    private val surveyService: SurveyService
) {

    @PostMapping
    @ApiOperation(value = "사전 참여 신청")
    fun create(
        @RequestBody surveyPostReqDto: @Valid SurveyPostReqDto
    ): ResponseEntity<SurveyPostResDto> {
        return ResponseEntity.ok(surveyService.createSurvey(surveyPostReqDto))
    }

}
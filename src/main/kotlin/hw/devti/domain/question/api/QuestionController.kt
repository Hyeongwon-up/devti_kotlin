package hw.devti.domain.question.api

import hw.devti.domain.question.dto.QuestionResDto
import hw.devti.domain.question.service.QuestionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/question")
@Api(value = "Question")
class QuestionController(
    private val questionService: QuestionService
) {

    @GetMapping(value = ["/all"])
    @ApiOperation(value = "모든 질문 및 선택 가져오기")
    fun getAllQuestionAndPreset(): ResponseEntity<List<QuestionResDto>> {
        return ResponseEntity.ok(questionService.findAllQuestionAndPreset())
    }
}
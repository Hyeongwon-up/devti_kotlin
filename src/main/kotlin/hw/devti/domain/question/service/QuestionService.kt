package hw.devti.domain.question.service

import hw.devti.domain.preset.service.PresetService
import hw.devti.domain.question.dao.QuestionRepository
import hw.devti.domain.question.dto.QuestionResDto
import hw.devti.domain.question.entity.Question
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
    private val presetService: PresetService
) {

    fun findAllQuestionAndPreset(): List<QuestionResDto> {
        var questions = questionRepository.findAll()
        var allQuestionAndPresetResDtos: MutableList<QuestionResDto> = ArrayList(questions.size)

        for(question: Question in questions) {
            allQuestionAndPresetResDtos.add(setQuestionResDto(question))
        }

        return allQuestionAndPresetResDtos
    }

    fun setQuestionResDto(question: Question): QuestionResDto {
        return QuestionResDto.toResDto(question, presetService.findAllPresetByQuestionId(question.id))
    }
}
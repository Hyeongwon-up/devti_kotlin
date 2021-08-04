package hw.devti.domain.question.dto

import hw.devti.domain.preset.dto.PresetResDto
import hw.devti.domain.question.entity.Question
import hw.devti.global.code.AnswerType

data class QuestionResDto(

    var id: Long,
    var title: String,
    var answerType: AnswerType,
    var presets: List<PresetResDto>

) {
    companion object {
        fun toResDto(question: Question, presetResDtoList: List<PresetResDto>): QuestionResDto {
            return question.run {
                QuestionResDto(
                    id = id,
                    title = title,
                    answerType = answerType,
                    presets = presetResDtoList
                    )
            }
        }
    }
}
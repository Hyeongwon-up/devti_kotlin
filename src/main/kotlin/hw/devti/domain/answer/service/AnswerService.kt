package hw.devti.domain.answer.service

import hw.devti.domain.answer.dao.AnswerRepository
import hw.devti.domain.answer.entity.Answer
import hw.devti.domain.answer.entity.AnswerAttribute
import org.springframework.stereotype.Service

@Service
class AnswerService(private val answerRepository: AnswerRepository) {

    fun createAnswer(answerAttributeList: List<AnswerAttribute>): Answer {
        val answer = Answer(answerList = answerAttributeList)
        return answerRepository.save(answer)
    }
}
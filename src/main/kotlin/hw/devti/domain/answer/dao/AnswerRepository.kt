package hw.devti.domain.answer.dao

import hw.devti.domain.answer.entity.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long> {
}
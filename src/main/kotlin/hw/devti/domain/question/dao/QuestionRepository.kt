package hw.devti.domain.question.dao

import hw.devti.domain.question.entity.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository: JpaRepository<Question, Long> {
}
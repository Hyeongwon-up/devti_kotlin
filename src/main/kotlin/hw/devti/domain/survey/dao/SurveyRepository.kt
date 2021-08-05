package hw.devti.domain.survey.dao

import hw.devti.domain.survey.entity.Survey
import org.springframework.data.jpa.repository.JpaRepository

interface SurveyRepository: JpaRepository<Survey, Long> {

    fun findByPhone(phone: String): Survey?

    fun findByEmail(mail: String): Survey?
}
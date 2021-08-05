package hw.devti.domain.survey.entity

import hw.devti.global.code.SurveyType
import hw.devti.global.code.TestType
import hw.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Survey(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    var id: Long ?= null,

    @Column(length = 500)
    var comment: String,

    @Enumerated(EnumType.STRING)
    var surveyType: SurveyType,

    @Column(length = 100, unique = true)
    var email: String,

    @Column(length = 50, unique = true)
    var phone: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    var testType: TestType

): BaseTimeEntity()
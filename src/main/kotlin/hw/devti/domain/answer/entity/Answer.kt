package hw.devti.domain.answer.entity

import hw.devti.domain.answer.util.AnswerAttributeConverter
import javax.persistence.*

@Entity
class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private var id: Long ?= null,

    @Lob
    @Convert(converter = AnswerAttributeConverter::class)
    @Column(name = "answer_list")
    private var answerList: List<AnswerAttribute>

    )
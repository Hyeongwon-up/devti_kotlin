package hw.devti.domain.devti.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import hw.devti.domain.answer.entity.Answer
import javax.persistence.*

@Entity
class Devti (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    var answer: Answer,

    @Column(name = "devti")
    var devti: String,

    @Column(name = "devti_result")
    var devtiResult: String

)


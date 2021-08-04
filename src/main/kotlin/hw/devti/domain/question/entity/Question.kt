package hw.devti.domain.question.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import hw.devti.domain.preset.entity.Preset
import hw.devti.global.code.AnswerType
import hw.devti.global.code.Pillar
import hw.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Question(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    var id: Long,

    @Column(name = "title", length = 100)
    var title: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "pillar")
    var pillar: Pillar,

    @Enumerated(EnumType.STRING)
    @Column(name = "answer_type")
    var answerType: AnswerType,

    @JsonManagedReference
    @OneToMany(mappedBy = "label", cascade = [CascadeType.ALL], orphanRemoval = true)
    var labels: Set<Preset> = HashSet()

): BaseTimeEntity()
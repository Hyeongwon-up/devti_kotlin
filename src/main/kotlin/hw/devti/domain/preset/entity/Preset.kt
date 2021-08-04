package hw.devti.domain.preset.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import hw.devti.domain.question.entity.Question
import hw.devti.global.code.BiasType
import hw.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Preset(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preset_id")
    var id: Long,

    @Column(name = "sequence")
    var sequence: Long,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    var question: Question,

    @Column(length = 100)
    var label: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "bias")
    var bias: BiasType,

    @Column(name = "weight")
    var weight: Float

): BaseTimeEntity()
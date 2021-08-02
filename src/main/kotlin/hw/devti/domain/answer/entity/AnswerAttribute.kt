package hw.devti.domain.answer.entity

import com.google.common.cache.Weigher
import hw.devti.global.code.AnswerType
import hw.devti.global.code.BiasType
import javax.validation.constraints.Min

class AnswerAttribute(

    var id: Long?= null,

    var answerType: AnswerType,

    var sequence: Long,

    var bias: BiasType,

    @Min(0)
    var weight: Float

)


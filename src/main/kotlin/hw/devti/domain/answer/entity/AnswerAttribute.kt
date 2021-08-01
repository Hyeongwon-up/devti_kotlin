package hw.devti.domain.answer.entity

import com.google.common.cache.Weigher
import hw.devti.global.code.AnswerType
import hw.devti.global.code.BiasType
import javax.validation.constraints.Min

class AnswerAttribute(

    private var id: Long?= null,

    private var answerType: AnswerType,

    private var sequence: Long,

    private var bias: BiasType,

    @Min(0)
    private var weight: Float

)


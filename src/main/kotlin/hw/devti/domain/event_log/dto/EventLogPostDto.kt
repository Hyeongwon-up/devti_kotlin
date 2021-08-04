package hw.devti.domain.event_log.dto

import hw.devti.domain.event_log.entity.EventLog
import hw.devti.domain.review.dto.ReviewResDto
import hw.devti.domain.review.entity.Review
import hw.devti.global.code.EventType
import hw.devti.global.code.TestType
import io.swagger.annotations.ApiModelProperty

data class EventLogPostReqDto(

    @ApiModelProperty(value = "event type", example = "CLICK_CTA_BUTTON")
    var eventType: EventType,

    @ApiModelProperty(value = "Bucket test type", example = "TYPE_COMMON_1")
    var testType: TestType

)


data class EventLogPostResDto(

    var id: Long,

    var testType: TestType,

    var eventType: EventType


) {
    companion object {
        fun toResDto(eventLog: EventLog): EventLogPostResDto {
            return eventLog.run {
                EventLogPostResDto(id = id!!, testType = testType, eventType = eventType)
            }
        }
    }
}

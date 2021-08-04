package hw.devti.domain.event_log.service

import hw.devti.domain.event_log.dao.EventLogRepository
import hw.devti.domain.event_log.dto.EventLogPostReqDto
import hw.devti.domain.event_log.dto.EventLogPostResDto
import hw.devti.domain.event_log.entity.EventLog
import hw.devti.global.code.EventType
import org.springframework.stereotype.Service

@Service
class EventLogService(
    private val eventLogRepository: EventLogRepository
) {

    fun createEventLog(eventLogPostReqDto: EventLogPostReqDto): EventLogPostResDto {
        val eventLog = EventLog(
            eventType = eventLogPostReqDto.eventType,
            testType = eventLogPostReqDto.testType
        )

        val saved = eventLogRepository.save(eventLog)
        val eventLogPostResDto = EventLogPostResDto.toResDto(saved)

        return eventLogPostResDto
    }

    fun findCountByEventType(eventType: EventType): Long {
        return eventLogRepository.countAllByEventType(eventType)
    }

}
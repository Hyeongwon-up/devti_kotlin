package hw.devti.domain.event_log.entity

import hw.devti.global.code.EventType
import hw.devti.global.code.TestType
import javax.persistence.*

class EventLog(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_log_id")
    var id: Long ?= null,

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    var eventType: EventType,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    var testType: TestType
)
package hw.devti.domain.bucket_test_type.entity

import hw.devti.global.code.TestType
import hw.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class BucketTestType(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long ?= null,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type", insertable = false, updatable = false)
    private var testType: TestType,

    @Column(name = "description")
    private var description: String,

    @Column(name = "phrases")
    private var phrases: String

) : BaseTimeEntity() {
}
package hw.devti.domain.bucket_test_type.entity

import hw.devti.global.code.TestType
import hw.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class BucketTestType(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type", insertable = false, updatable = false)
    var testType: TestType,

    @Column(name = "description")
    var description: String,

    @Column(name = "phrases")
    var phrases: String

) : BaseTimeEntity() {
}
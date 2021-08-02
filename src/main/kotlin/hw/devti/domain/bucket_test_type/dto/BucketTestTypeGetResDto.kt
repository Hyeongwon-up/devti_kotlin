package hw.devti.domain.bucket_test_type.dto

import hw.devti.global.code.TestType

data class BucketTestTypeGetResDto(

    private var testType: TestType,
    private var phrases: String
)
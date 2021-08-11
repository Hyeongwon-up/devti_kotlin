package hw.devti.domain.bucket_test_type.dto

import hw.devti.domain.bucket_test_type.entity.BucketTestType
import hw.devti.global.code.TestType

data class BucketTestTypeGetResDto(

    private var testType: TestType,
    private var phrases: String
) {
    companion object{
        fun toResDto(bucketTestType: BucketTestType): BucketTestTypeGetResDto {
            bucketTestType.run {
              return BucketTestTypeGetResDto(testType = testType, phrases = phrases)
            }
        }
    }
}
package hw.devti.domain.bucket_test_type.dao

import hw.devti.domain.bucket_test_type.entity.BucketTestType
import hw.devti.global.code.TestType
import org.springframework.data.jpa.repository.JpaRepository

interface BucketTestTypeRepository: JpaRepository<BucketTestType, Long> {

    fun findByTestType(testType: TestType): BucketTestType
}
package hw.devti.domain.bucket_test_type.service

import hw.devti.domain.bucket_test_type.dao.BucketTestTypeRepository
import hw.devti.domain.bucket_test_type.dto.BucketTestTypeGetResDto
import hw.devti.domain.bucket_test_type.entity.BucketTestType
import hw.devti.domain.traffic.entity.Traffic
import hw.devti.domain.traffic.service.TrafficService
import hw.devti.global.code.EntryPoint
import hw.devti.global.code.TestType
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
class BucketTestTypeService(
    private val bucketTestTypeRepository: BucketTestTypeRepository,
    private val trafficService: TrafficService
){

    @Transactional
    fun getBucketTestTypeAndCreateTraffic(entryPoint: EntryPoint): BucketTestTypeGetResDto {

        val testType = getNextTestType(entryPoint)
        val traffic = Traffic(testType = testType)

        trafficService.saveTraffic(traffic)

        val bucketTestType = bucketTestTypeRepository.findByTestType(testType)

        return BucketTestTypeGetResDto(testType = bucketTestType.testType, phrases = bucketTestType.phrases)

    }

    fun getNextTestType(entryPoint: EntryPoint): TestType {
        if(entryPoint.getValue().equals("mom")) {
            return TestType.TYPE_MOM_CAFE_1
        }
        val lastTrafficType = trafficService.getLastTraffic().testType

        return lastTrafficType.getNext()
    }
}
package hw.devti.domain.bucket_test_type.api

import hw.devti.domain.bucket_test_type.service.BucketTestTypeService
import hw.devti.global.code.EntryPoint
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bucket-test-type")
@Api(value = "BucketTestType")
class BucketTestTypeController(private val bucketTestTypeService: BucketTestTypeService) {

    @GetMapping(value = ["/{entryPoint}"])
    @ApiOperation(value = "Bucket test 문구 가져오기")
    fun getBucketTestTypeAndCreateTraffic(@PathVariable entryPoint: EntryPoint) {

    }
}
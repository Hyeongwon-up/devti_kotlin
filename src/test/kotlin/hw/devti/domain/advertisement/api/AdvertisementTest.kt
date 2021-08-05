package hw.devti.domain.advertisement.api

import hw.devti.domain.advertisement.entity.Advertisement
import hw.devti.domain.advertisement.service.AdvertisementService
import hw.devti.global.code.AdvertisementType
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.provider.EnumSource


internal class AdvertisementTest(): StringSpec(){

    @MockK
    private lateinit var advertisementService: AdvertisementService

    @InjectMockKs
    private lateinit var advertisementController: AdvertisementController




    override fun beforeEach(testCase: TestCase) {
    }

    init{
        "광고 리스트 불러오기 테스트" {

            //given
            var advertisementType = AdvertisementType.ALL
            every { advertisementService.findAllAdvertisementByAdvertisementType(advertisementType)}






        }
    }




}
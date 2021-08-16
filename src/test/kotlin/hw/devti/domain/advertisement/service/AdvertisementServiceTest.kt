package hw.devti.domain.advertisement.service

import hw.devti.domain.advertisement.dao.AdvertisementRepository
import hw.devti.global.code.AdvertisementType
import io.kotest.core.datatest.forAll
import io.kotest.core.script.context
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AdvertisementServiceTest : StringSpec({

    val advertisementRepository = mockk<AdvertisementRepository>()
    val advertisementService = AdvertisementService(advertisementRepository)


    "광고 타입에 맞는 모든 광고 가져오기"{
        checkAll(
            Exhaustive.enum<AdvertisementType>()
        ) { advertisementType -> ""

    }



})

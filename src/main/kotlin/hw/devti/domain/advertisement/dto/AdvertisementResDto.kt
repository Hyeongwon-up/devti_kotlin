package hw.devti.domain.advertisement.dto

import hw.devti.domain.advertisement.entity.Advertisement
import hw.devti.global.code.AdvertisementType
import lombok.Builder
import java.time.LocalDate

data class AdvertisementResDto(

    private var id: Long,
    private var advertiser: String,
    private var title: String,
    private var imageUrl: String,
    private var advertisementStartDate: LocalDate,
    private var advertisementEndDate: LocalDate,
    private var advertisementType: AdvertisementType

)

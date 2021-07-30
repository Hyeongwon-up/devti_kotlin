package hw.devti.domain.advertisement.service

import hw.devti.domain.advertisement.dao.AdvertisementRepository
import hw.devti.domain.advertisement.dto.AdvertisementResDto
import hw.devti.domain.advertisement.entity.Advertisement
import hw.devti.global.code.AdvertisementType
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AdvertisementService(private val advertisementRepository: AdvertisementRepository) {

    fun findAllAdvertisementByAdvertisementType(advertisementType: AdvertisementType): List<AdvertisementResDto>? {

        val advertisements: List<Advertisement> = advertisementRepository
            .findAllByAdvertisementType(advertisementType)

        return advertisements.stream()
            .map<Any>(AdvertisementResDto::convertResponseDto)
            .collect(Collectors.toList())
    }


}
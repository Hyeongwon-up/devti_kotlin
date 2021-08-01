package hw.devti.domain.advertisement.dao

import hw.devti.domain.advertisement.entity.Advertisement
import org.springframework.data.jpa.repository.JpaRepository

interface AdvertisementRepository : JpaRepository<Advertisement, Long>, AdvertisementRepositorySupport {
}
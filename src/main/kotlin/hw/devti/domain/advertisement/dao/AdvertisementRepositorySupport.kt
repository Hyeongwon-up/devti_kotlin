package hw.devti.domain.advertisement.dao

import com.querydsl.jpa.impl.JPAQueryFactory
import hw.devti.domain.advertisement.entity.Advertisement
import hw.devti.global.code.AdvertisementType
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

interface AdvertisementRepositorySupport {

    @Transactional(readOnly = true)
    fun findAllByAdvertisementType(advertisementType: AdvertisementType): List<Advertisement>
}
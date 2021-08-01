package hw.devti.domain.advertisement.dao

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import hw.devti.domain.advertisement.entity.Advertisement
import hw.devti.domain.advertisement.entity.QAdvertisement
import hw.devti.global.code.AdvertisementType
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import java.time.LocalDate
import javax.annotation.Resource

class AdvertisementRepositorySupportImpl(
    @Resource(name = "jpaQueryFactory")
    val jpaQueryFactory: JPAQueryFactory,
    val advertisement: QAdvertisement = QAdvertisement.advertisement


) : QuerydslRepositorySupport(Advertisement::class.java), AdvertisementRepositorySupport {

    override fun findAllByAdvertisementType(advertisementType: AdvertisementType): List<Advertisement> {
        return jpaQueryFactory.selectFrom(advertisement)
            .where(
                advertisement.advertisementStartDate.before(LocalDate.now())
                    .and(advertisement.advertisementEndDate.after(LocalDate.now()))
                    .and(validateAdvertisementType(advertisementType))
            )
            .fetch()
    }

    private fun validateAdvertisementType(advertisementType: AdvertisementType): BooleanExpression? {
        if (advertisementType.equals(AdvertisementType.LECTURE)) {
            return advertisement.advertisementType.eq(AdvertisementType.LECTURE)
        }
        if (advertisementType.equals(AdvertisementType.RECRUIT)) {
            return advertisement.advertisementType.eq(AdvertisementType.RECRUIT)
        }
        if (advertisementType.equals(AdvertisementType.ETC)) {
            return advertisement.advertisementType.eq(AdvertisementType.ETC)
        } else return null
    }


}
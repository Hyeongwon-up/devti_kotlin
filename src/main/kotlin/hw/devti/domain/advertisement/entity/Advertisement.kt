package hw.devti.domain.advertisement.entity

import hw.devti.global.code.AdvertisementType
import java.time.LocalDate
import javax.persistence.*

@Entity
class Advertisement(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private var id: Long = 0,

    @Column(name = "advertiser")
    private var advertiser: String,

    @Column(name = "title")
    private var title: String,

    @Column(name = "imageUrl")
    private var imagerUrl: String,

    @Column(name = "advertisement_start_date")
    private var advertisementStartDate: LocalDate,

    @Column(name = "advertisement_end_date")
    private var advertisementEndDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(name = "advertisement_type", insertable = false, updatable = false)
    private var advertisementType: AdvertisementType


)
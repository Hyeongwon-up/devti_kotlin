package hw.devti.domain.traffic.dao

import hw.devti.domain.traffic.entity.Traffic
import org.springframework.data.jpa.repository.JpaRepository

interface TrafficRepository: JpaRepository<Traffic, Long> {

    fun findTopByOrderByIdDesc(): Traffic
}
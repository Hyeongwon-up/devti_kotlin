package hw.devti.domain.devti.dao

import hw.devti.domain.devti.entity.Devti
import org.springframework.data.jpa.repository.JpaRepository

interface DevtiRepository: JpaRepository<Devti, Long> {
}
package hw.devti.domain.bias.dao

import hw.devti.domain.bias.entity.Bias
import hw.devti.global.code.BiasType
import org.springframework.data.jpa.repository.JpaRepository

interface BiasRepository: JpaRepository<Bias, Long> {

    fun findAllByBiasIsNotIn(biasTypes: List<BiasType>): List<Bias>
}
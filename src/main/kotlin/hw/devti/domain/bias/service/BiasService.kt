package hw.devti.domain.bias.service

import hw.devti.domain.bias.dao.BiasRepository
import hw.devti.domain.bias.entity.Bias
import hw.devti.global.code.BiasType
import org.springframework.stereotype.Service

@Service
class BiasService(
    private val biasRepository: BiasRepository
) {

    fun findBiasListByBiasIsNotIn(biasTypes: List<BiasType>): List<Bias> {
        return biasRepository.findAllByBiasIsNotIn(biasTypes)
    }

}
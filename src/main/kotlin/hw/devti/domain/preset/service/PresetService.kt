package hw.devti.domain.preset.service

import hw.devti.domain.preset.dao.PresetRepository
import hw.devti.domain.preset.dto.PresetResDto
import hw.devti.domain.preset.entity.Preset
import hw.devti.global.error.ErrorCode
import hw.devti.global.error.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class PresetService(
    private val presetRepository: PresetRepository
) {

    @Throws(BusinessException::class)
    fun findAllPresetByQuestionId(questionId: Long): List<PresetResDto> {
        val presets = presetRepository.findAllByQuestionId(questionId)

        var presetResDtos: MutableList<PresetResDto> = ArrayList(presets.size)

        presets.stream().forEach { preset: Preset ->
            presetResDtos.add(
                PresetResDto.toResDto(preset)
            )
        }

        return presetResDtos
    }
}
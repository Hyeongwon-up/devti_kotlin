package hw.devti.domain.preset.dto

import hw.devti.domain.preset.entity.Preset
import hw.devti.global.code.BiasType

data class PresetResDto(

    var key: Long,

    var label: String,

    var bias: BiasType,

    var weight: Float,

    var sequence: Long

) {

    companion object {
        fun toResDto(preset: Preset): PresetResDto {
            return preset.run {
                PresetResDto(key = sequence, label = label, bias = bias, weight = weight, sequence = sequence)
            }
        }
    }
}
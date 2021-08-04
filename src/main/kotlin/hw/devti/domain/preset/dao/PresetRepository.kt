package hw.devti.domain.preset.dao

import hw.devti.domain.preset.entity.Preset
import org.springframework.data.jpa.repository.JpaRepository

interface PresetRepository: JpaRepository<Preset, Long> {

    fun findAllByQuestionId(questionId: Long): List<Preset>
}
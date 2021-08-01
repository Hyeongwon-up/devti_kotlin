package hw.devti.domain.answer.util

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import hw.devti.domain.answer.entity.AnswerAttribute
import javax.persistence.AttributeConverter

class AnswerAttributeConverter : AttributeConverter<List<AnswerAttribute>, String> {

    companion object {
        private val objectMapper = ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
        )
    }

    override fun convertToDatabaseColumn(answerAttributeList: List<AnswerAttribute>): String {
        return try {
            objectMapper.writeValueAsString(answerAttributeList)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException(answerAttributeList.toString())
        }
    }

    override fun convertToEntityAttribute(dbData: String): List<AnswerAttribute> {
        return try {
            objectMapper.readValue<List<AnswerAttribute>>(
                dbData,
                objectMapper.typeFactory.constructCollectionType(
                    MutableList::class.java,
                    AnswerAttribute::class.java
                )
            )
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException(dbData)
        }
    }





}

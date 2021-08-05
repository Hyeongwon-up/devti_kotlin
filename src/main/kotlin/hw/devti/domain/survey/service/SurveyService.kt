package hw.devti.domain.survey.service

import `in`.ashwanthkumar.slack.webhook.Slack
import hw.devti.domain.survey.dao.SurveyRepository
import hw.devti.domain.survey.dto.SurveyPostReqDto
import hw.devti.domain.survey.dto.SurveyPostResDto
import hw.devti.domain.survey.entity.Survey
import hw.devti.global.error.ErrorCode
import hw.devti.global.error.exception.InvalidValueException
import hw.devti.global.util.SlackPusher
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Service
class SurveyService(
    @Value("\${constant.slack.survey-monitoring-channel-url}")
    private val slackSurveyMonitoringChannelUrl: String,
    @Value("\${constant.slack.survey-monitoring-channel-name}")
    private val slackSurveyMonitoringChannelName: String,
    private val surveyRepository: SurveyRepository
) {

    @Transactional
    fun createSurvey(surveyPostReqDto: SurveyPostReqDto): SurveyPostResDto {
        if (isFilledWithPhoneSurvey(surveyPostReqDto)) {
            checkDuplicatedSurveyByPhone(surveyPostReqDto.phone)
        } else {
            checkDuplicatedSurveyByEmail(surveyPostReqDto.email)
        }

        val survey = Survey(
            comment = surveyPostReqDto.comment,
            surveyType = surveyPostReqDto.surveyType,
            email = surveyPostReqDto.email,
            phone = surveyPostReqDto.phone,
            testType = surveyPostReqDto.testType
        )

        return SurveyPostResDto.toResDto(survey)
    }

    fun isFilledWithPhoneSurvey(surveyPostReqDto: SurveyPostReqDto): Boolean {
        return surveyPostReqDto.phone != null
    }

    fun checkDuplicatedSurveyByPhone(phone: String) {
        if (surveyRepository.findByPhone(phone) != null) {
            throw InvalidValueException(phone, ErrorCode.PHONE_DUPLICATION)
        }
    }

    fun checkDuplicatedSurveyByEmail(email: String) {
        if (surveyRepository.findByEmail(email) != null) {
            throw InvalidValueException(email, ErrorCode.EMAIL_DUPLICATION)
        }
    }

    private fun pushMessage(registeredSurvey: Survey){
        var slackPusher = SlackPusher.slackPusher(slackSurveyMonitoringChannelUrl,
        "#" + slackSurveyMonitoringChannelName)

        SlackPusher.pushMessage(
            "*신규 사전 참여 신청이 들어왔습니다!*"
                    + "\n- Comment : " + registeredSurvey.comment
                    + "\n- Test Type: " + registeredSurvey.testType
        )
    }


}
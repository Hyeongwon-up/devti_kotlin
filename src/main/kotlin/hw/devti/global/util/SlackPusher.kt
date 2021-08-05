package hw.devti.global.util

import `in`.ashwanthkumar.slack.webhook.Slack
import `in`.ashwanthkumar.slack.webhook.SlackMessage
import java.io.IOException

class SlackPusher(
    private var slack: Slack
) {
    fun SlackPusher(webhookurl: String, channel: String) {
        this.slack = Slack(webhookurl)
            .icon(":smiling_imp")
            .sendToChannel(channel)
            .displayName("DEVTI")
    }

    fun pushMessage(message: String) {
        var slackMessage: SlackMessage = SlackMessage(message)

        try {
            slack.push(slackMessage)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
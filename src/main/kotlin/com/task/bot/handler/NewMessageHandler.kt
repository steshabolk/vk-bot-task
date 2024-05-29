package com.task.bot.handler

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.task.bot.config.ApplicationConfig
import com.task.bot.enums.CallbackType
import com.task.bot.model.vk.callback.VkCallback
import com.task.bot.model.vk.objects.NewMessageObject
import com.task.bot.model.vk.response.VkResponseParams
import com.task.bot.service.VkService
import org.springframework.stereotype.Component

@Component
class NewMessageHandler(
    private val applicationConfig: ApplicationConfig,
    private val vkService: VkService
) : CallbackHandler {
    private val mapper = jacksonObjectMapper()

    override val type: CallbackType = CallbackType.MESSAGE_NEW

    override fun handle(vkCallback: VkCallback): String {
        val newMessage = mapper.convertValue(vkCallback.callbackObject, NewMessageObject::class.java).message
        val response = VkResponseParams(
            userId = newMessage.fromId,
            randomId = System.currentTimeMillis(),
            peerId = newMessage.peerId,
            message = buildReplyMessage(newMessage.text))
        vkService.sendMessage(response)
        return applicationConfig.vkConfig.callbackResponse
    }

    private fun buildReplyMessage(message: String) =
        "Вы сказали: $message"
}

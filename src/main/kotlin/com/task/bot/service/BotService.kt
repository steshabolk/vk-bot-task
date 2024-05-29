package com.task.bot.service

import com.task.bot.exception.ApiException
import com.task.bot.handler.CallbackHandler
import com.task.bot.model.vk.callback.VkCallback
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BotService(
    private val callbackHandlers: List<CallbackHandler>
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun processCallback(vkCallback: VkCallback): String {
        log.debug(vkCallback.toString())
        return callbackHandlers
            .firstOrNull { it.isTriggered(vkCallback) }
            ?.handle(vkCallback)
            ?: throw ApiException("Unsupported callback type: $vkCallback")
    }
}

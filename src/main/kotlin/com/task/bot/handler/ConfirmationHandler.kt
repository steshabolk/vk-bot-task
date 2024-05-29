package com.task.bot.handler

import com.task.bot.config.ApplicationConfig
import com.task.bot.enums.CallbackType
import com.task.bot.model.vk.callback.VkCallback
import org.springframework.stereotype.Component

@Component
class ConfirmationHandler(
    private val applicationConfig: ApplicationConfig
) : CallbackHandler {
    override val type: CallbackType = CallbackType.CONFIRMATION

    override fun handle(vkCallback: VkCallback) =
        applicationConfig.vkConfig.confirmationToken
}

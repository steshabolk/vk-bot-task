package com.task.bot.handler

import com.task.bot.enums.CallbackType
import com.task.bot.model.vk.callback.VkCallback

interface CallbackHandler {
    val type: CallbackType

    fun isTriggered(vkCallback: VkCallback) =
        vkCallback.type == type

    fun handle(vkCallback: VkCallback): String
}

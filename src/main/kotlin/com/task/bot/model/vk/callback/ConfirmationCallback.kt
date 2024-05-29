package com.task.bot.model.vk.callback

import com.fasterxml.jackson.annotation.JsonProperty
import com.task.bot.enums.CallbackType

data class ConfirmationCallback(
    override val callbackObject: Any? = null,
    @JsonProperty("group_id")
    override val groupId: Long
) : VkCallback(type = CallbackType.CONFIRMATION)

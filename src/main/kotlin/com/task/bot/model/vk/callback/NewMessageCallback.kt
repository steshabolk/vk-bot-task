package com.task.bot.model.vk.callback

import com.fasterxml.jackson.annotation.JsonProperty
import com.task.bot.enums.CallbackType
import com.task.bot.model.vk.objects.NewMessageObject

data class NewMessageCallback(
    override val callbackObject: NewMessageObject,
    @JsonProperty("group_id")
    override val groupId: Long
) : VkCallback(type = CallbackType.MESSAGE_NEW)

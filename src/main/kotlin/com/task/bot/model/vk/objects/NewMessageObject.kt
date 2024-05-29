package com.task.bot.model.vk.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class NewMessageObject(
    val message: VkNewMessage
)

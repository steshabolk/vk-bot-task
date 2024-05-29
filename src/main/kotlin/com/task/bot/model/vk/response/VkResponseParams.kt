package com.task.bot.model.vk.response

data class VkResponseParams(
    val userId: Int,
    val peerId: Int,
    val randomId: Long,
    val message: String
)

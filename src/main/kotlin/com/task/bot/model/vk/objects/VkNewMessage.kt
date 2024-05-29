package com.task.bot.model.vk.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class VkNewMessage(
    val id: Int,
    @JsonProperty("peer_id")
    val peerId: Int,
    @JsonProperty("from_id")
    val fromId: Int,
    val text: String
)

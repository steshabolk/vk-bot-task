package com.task.bot.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
data class ApplicationConfig(
    val vkConfig: VkConfig
) {
    data class VkConfig(
        val api: String,
        val version: String,
        val accessToken: String,
        val confirmationToken: String,
        val groupId: String,
        val callbackResponse: String
    )
}

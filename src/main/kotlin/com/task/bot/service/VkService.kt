package com.task.bot.service

import com.task.bot.client.VkClient
import com.task.bot.config.ApplicationConfig
import com.task.bot.model.vk.response.VkResponseParams
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class VkService(
    private val applicationConfig: ApplicationConfig,
    private val vkClient: VkClient
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sendMessage(params: VkResponseParams) {
        val vkResponse = vkClient.sendMessage(
            accessToken = applicationConfig.vkConfig.accessToken,
            version = applicationConfig.vkConfig.version,
            userId = params.userId,
            peerId = params.peerId,
            randomId = params.randomId,
            message = params.message)
        log.debug("vk response: $vkResponse")
    }
}

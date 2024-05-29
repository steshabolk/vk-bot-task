package com.task.bot.client

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange(accept = [MediaType.APPLICATION_JSON_VALUE], contentType = MediaType.APPLICATION_JSON_VALUE)
interface VkClient {

    @PostExchange("/method/messages.send")
    fun sendMessage(@RequestParam("access_token") accessToken: String,
                    @RequestParam("v") version: String,
                    @RequestParam("user_id") userId: Int,
                    @RequestParam("peer_id") peerId: Int,
                    @RequestParam("random_id") randomId: Long,
                    @RequestParam("message") message: String): String
}

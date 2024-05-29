package com.task.bot.controller

import com.task.bot.model.vk.callback.VkCallback
import com.task.bot.service.BotService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class BotController(
    private val botService: BotService,
) {

    @PostMapping
    fun listen(@RequestBody vkCallback: VkCallback) =
        botService.processCallback(vkCallback)
}

package com.task.bot.config

import com.task.bot.client.VkClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Component
class ClientConfig(
    private val applicationConfig: ApplicationConfig
) {

    @Bean
    fun vkClient(): VkClient {
        val webClientAdapter = WebClientAdapter.create(
            WebClient.builder()
                .baseUrl(applicationConfig.vkConfig.api)
                .build())
        return HttpServiceProxyFactory.builderFor(webClientAdapter).build().createClient(VkClient::class.java)
    }
}

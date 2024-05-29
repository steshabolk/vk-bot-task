package com.task.bot

import com.task.bot.config.ApplicationConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig::class)
class BotApplication

fun main(args: Array<String>) {
	runApplication<BotApplication>(*args)
}

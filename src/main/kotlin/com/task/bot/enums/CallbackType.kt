package com.task.bot.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class CallbackType {
    @JsonProperty("confirmation")
    CONFIRMATION,

    @JsonProperty("message_new")
    MESSAGE_NEW
}

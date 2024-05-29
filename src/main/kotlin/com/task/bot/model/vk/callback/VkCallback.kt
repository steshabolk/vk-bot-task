package com.task.bot.model.vk.callback

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.task.bot.enums.CallbackType

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
)
@JsonSubTypes(
    JsonSubTypes.Type(value = NewMessageCallback::class, name = "message_new"),
    JsonSubTypes.Type(value = ConfirmationCallback::class, name = "confirmation")
)
@JsonIgnoreProperties(ignoreUnknown = true)
sealed class VkCallback(
    val type: CallbackType
) {
    @get:JsonProperty("object")
    abstract val callbackObject: Any?

    @get:JsonProperty("group_id")
    abstract val groupId: Long
}

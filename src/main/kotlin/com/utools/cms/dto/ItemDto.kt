package com.utools.cms.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern

interface Jsonable {
    fun toJson(): String
}

@Serializable
data class ItemDto(
    @field:Min(value = 0L, message = "price must be positive") val price: Int,
    @field:Pattern(regexp = "^[a-zA-Z0-9-]*$", message = "brand must be alphanumeric") val brand: String,
    @field:Pattern(regexp = "^[a-zA-Z0-9-]*$", message = "category must be alphanumeric") val category: String,
) : Jsonable {
    override fun toJson(): String = Json.encodeToString(this)
}

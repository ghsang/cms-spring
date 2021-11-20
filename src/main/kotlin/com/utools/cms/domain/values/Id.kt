package com.utools.cms.domain.values

import kotlinx.serialization.Serializable

val ID_PATTERN = "^[a-zA-Z0-9-]*$".toRegex()

@Serializable
@JvmInline
value class Id(val value: String) {
    init {
        require(ID_PATTERN.matches(value)) {
            "Id should contain only alpha numeric characters and '-'"
        }

        require(value.length < 255) {
            "Id's length should not greater than 255"
        }
    }
}

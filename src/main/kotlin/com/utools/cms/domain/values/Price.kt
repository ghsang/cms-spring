package com.utools.cms.domain.values

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Price(val value: Int) {
    init {
        require(value > 0) {
            "Price should be greater than zero"
        }
    }
}

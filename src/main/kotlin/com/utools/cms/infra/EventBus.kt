package com.utools.cms.infra

import com.utools.cms.dto.Jsonable
import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import io.github.resilience4j.retry.annotation.Retry
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component


const val RESILIENCE_NAME = "eventBus"

interface EventBus<in T> {
    fun publish(topic: String, data: T)
}

@Component
class KafkaEventBus<in T : Jsonable>(private val kafkaTemplate: KafkaTemplate<String, String>) : EventBus<T> {

    @CircuitBreaker(name = RESILIENCE_NAME)
    @Bulkhead(name = RESILIENCE_NAME)
    @RateLimiter(name = RESILIENCE_NAME)
    @Retry(name = RESILIENCE_NAME)
    override fun publish(topic: String, data: T) {
        kafkaTemplate.send(topic, data.toJson())
    }
}

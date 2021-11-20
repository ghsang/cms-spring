package com.utools.cms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.config.TopicBuilder


@SpringBootApplication
class CmsApplication

@Bean
fun createItemTopic() =
    TopicBuilder.name("CreateItem")
        .partitions(10)
        .replicas(1)
        .compact()
        .build()

fun main(args: Array<String>) {
    runApplication<CmsApplication>(*args)
}

package com.utools.cms.controllers

import com.utools.cms.dto.ItemDto
import com.utools.cms.infra.KafkaEventBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
class ItemController(@Autowired val eventBus: KafkaEventBus<ItemDto>) {
    @PostMapping("/createItem")
    suspend fun createItem(@Valid @RequestBody item: ItemDto): ItemDto {
        eventBus.publish("CreateItem", item)
        return item
    }
}

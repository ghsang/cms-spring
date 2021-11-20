package com.utools.cms.controllers

import com.utools.cms.dto.ItemDto
import com.utools.cms.infra.KafkaEventBus
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

@WebFluxTest
class ItemControllerTests(
    @Autowired val client: WebTestClient,
) {

    @MockBean private lateinit var eventBus: KafkaEventBus<ItemDto>

    @Test
    fun `POST createItem should return its input`() {

        val item =
            ItemDto(
                brand = "brand",
                category = "category",
                price = 1000,
            )

        client.post()
            .uri("/createItem")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(item))
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.brand")
            .isEqualTo("brand")
            .jsonPath("$.category")
            .isEqualTo("category")
            .jsonPath("$.price")
            .isEqualTo(1000)

        verify(eventBus).publish("CreateItem", item)
    }
}

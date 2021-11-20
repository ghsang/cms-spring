package com.utools.cms.utils.id

import com.utools.cms.domain.values.Id
import java.util.UUID

interface IdGenerator {
    fun generateId(): Id
}

class UUIDGenerator : IdGenerator {
    override fun generateId(): Id {
        return uuidToId(UUID.randomUUID())
    }
}

fun uuidToId(uuid: UUID): Id {
    return Id(uuid.toString())
}

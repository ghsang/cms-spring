package com.utools.cms.domain.entities

import com.utools.cms.domain.values.Brand
import com.utools.cms.domain.values.Category
import com.utools.cms.domain.values.Id
import com.utools.cms.domain.values.Price
import kotlinx.serialization.Serializable


@Serializable
data class Item(val id: Id, val brand: Brand, val category: Category, val price: Price)

package com.mikewilcome.pixelalchemy.domain

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class Element(
    val name: String,
    val density: Float,
    val color: RGB,
    val reactions: PersistentList<PhysicsRule> = persistentListOf()
)

data class RGB(val r: Int, val g: Int, val b: Int)
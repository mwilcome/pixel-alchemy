package com.mikewilcome.pixelalchemy.domain

sealed class PhysicsRule

data class InteractionRule(
    val elementA: Element,
    val elementB: Element,
    val resultA: Element?,
    val resultB: Element?
) : PhysicsRule()

data class GravityRule(
    val appliesTo: (Element) -> Boolean
) : PhysicsRule()
package com.mikewilcome.pixelalchemy.application

import com.mikewilcome.pixelalchemy.domain.InteractionRule
import com.mikewilcome.pixelalchemy.domain.SandboxState

class ApplyInteractionUseCase {
    fun execute(state: SandboxState): SandboxState {
        var newState = state
        // Check each cell and its neighbors
        for (y in 0 until state.height) {
            for (x in 0 until state.width) {
                val element = newState.get(x, y) ?: continue
                // Check the element's reactions for InteractionRules
                val interactionRules = element.reactions.filterIsInstance<InteractionRule>()
                if (interactionRules.isEmpty()) continue

                // Check adjacent cells (up, down, left, right)
                val neighbors = listOf(
                    Pair(x, y - 1), // Up
                    Pair(x, y + 1), // Down
                    Pair(x - 1, y), // Left
                    Pair(x + 1, y)  // Right
                )

                for ((nx, ny) in neighbors) {
                    val neighbor = newState.get(nx, ny) ?: continue
                    // Find a matching InteractionRule
                    val rule = interactionRules.firstOrNull { rule ->
                        (rule.elementA == element && rule.elementB == neighbor) ||
                                (rule.elementA == neighbor && rule.elementB == element)
                    } ?: continue

                    // Apply the interaction
                    val (newElement, newNeighbor) = if (rule.elementA == element) {
                        Pair(rule.resultA, rule.resultB)
                    } else {
                        Pair(rule.resultB, rule.resultA)
                    }
                    newState = newState.set(x, y, newElement).set(nx, ny, newNeighbor)
                }
            }
        }
        return newState
    }
}
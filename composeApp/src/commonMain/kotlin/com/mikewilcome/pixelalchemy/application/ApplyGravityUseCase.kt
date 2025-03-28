package com.mikewilcome.pixelalchemy.application

import com.mikewilcome.pixelalchemy.domain.Element
import com.mikewilcome.pixelalchemy.domain.GravityRule
import com.mikewilcome.pixelalchemy.domain.SandboxState

class ApplyGravityUseCase {
    fun execute(state: SandboxState): SandboxState {
        var newState = state
        // Iterate from bottom to top to ensure proper gravity simulation
        for (y in (state.height - 1) downTo 0) {
            for (x in 0 until state.width) {
                val element = newState.get(x, y) ?: continue
                // Check if the element has a GravityRule in its reactions
                val gravityRule = element.reactions.filterIsInstance<GravityRule>().firstOrNull { it.appliesTo(element) }
                if (gravityRule != null && y < state.height - 1) {
                    val below = newState.get(x, y + 1)
                    if (below == null) {
                        // Move the element down
                        newState = newState.set(x, y, null).set(x, y + 1, element)
                    } else if (below.density < element.density) {
                        // Swap if the element below has lower density
                        newState = newState.set(x, y, below).set(x, y + 1, element)
                    }
                }
            }
        }
        return newState
    }
}
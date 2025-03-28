package com.mikewilcome.pixelalchemy.application

import com.mikewilcome.pixelalchemy.domain.Element
import com.mikewilcome.pixelalchemy.domain.SandboxState

class PlaceElementUseCase {
    fun execute(state: SandboxState, x: Int, y: Int, element: Element?): SandboxState {
        return state.set(x, y, element)
    }
}
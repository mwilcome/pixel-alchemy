package com.mikewilcome.pixelalchemy.application

import com.mikewilcome.pixelalchemy.domain.SandboxState

class ClearGridUseCase {
    fun execute(state: SandboxState): SandboxState {
        return SandboxState.createEmpty(state.width, state.height)
    }
}
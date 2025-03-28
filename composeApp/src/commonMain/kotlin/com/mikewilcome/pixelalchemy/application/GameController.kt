package com.mikewilcome.pixelalchemy.application

import com.mikewilcome.pixelalchemy.domain.Element
import com.mikewilcome.pixelalchemy.domain.SandboxState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameController(
    private val placeElementUseCase: PlaceElementUseCase,
    private val applyGravityUseCase: ApplyGravityUseCase,
    private val applyInteractionUseCase: ApplyInteractionUseCase,
    private val clearGridUseCase: ClearGridUseCase
) {
    private val _state = MutableStateFlow(
        SandboxState.createEmpty(width = 100, height = 100) // Initial state
    )
    val state: StateFlow<SandboxState> = _state.asStateFlow()

    fun placeElement(x: Int, y: Int, element: Element?) {
        val currentState = _state.value
        val newState = placeElementUseCase.execute(currentState, x, y, element)
        _state.value = newState
    }

    fun applyPhysics() {
        var currentState = _state.value
        // Apply gravity first
        currentState = applyGravityUseCase.execute(currentState)
        // Then apply interactions
        currentState = applyInteractionUseCase.execute(currentState)
        _state.value = currentState
    }

    fun clearGrid() {
        val currentState = _state.value
        val newState = clearGridUseCase.execute(currentState)
        _state.value = newState
    }
}
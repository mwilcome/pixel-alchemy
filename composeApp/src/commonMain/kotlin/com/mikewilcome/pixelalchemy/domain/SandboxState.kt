package com.mikewilcome.pixelalchemy.domain

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class SandboxState(
    val grid: PersistentList<PersistentList<Element?>>
) {
    val width: Int get() = grid[0].size
    val height: Int get() = grid.size

    fun get(x: Int, y: Int): Element? {
        return if (x in 0 until width && y in 0 until height) grid[y][x] else null
    }

    fun set(x: Int, y: Int, element: Element?): SandboxState {
        if (x !in 0 until width || y !in 0 until height) return this
        val newRow = grid[y].set(x, element)
        val newGrid = grid.set(y, newRow)
        return copy(grid = newGrid)
    }

    companion object {
        fun createEmpty(width: Int = 100, height: Int = 100): SandboxState {
            val emptyRow = persistentListOf<Element?>().addAll(List(width) { null })
            return SandboxState(persistentListOf<PersistentList<Element?>>().addAll(List(height) { emptyRow }))
        }
    }
}
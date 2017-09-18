package io.github.ranolp.correctarrow.game

import java.util.*

enum class ArrowTo(vararg val id: Int) {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3),
    TOP_LEFT(0, 2),
    BOTTOM_LEFT(0, 3),
    TOP_RIGHT(1, 2),
    BOTTOM_RIGHT(1, 3);

    companion object {
        private val rand = Random()
        fun randomLeft() = when (rand.nextInt(2)) {
            0 -> LEFT
            1 -> TOP_LEFT
            else -> BOTTOM_LEFT
        }
        fun randomRight() = when (rand.nextInt(2)) {
            0 -> RIGHT
            1 -> TOP_RIGHT
            else -> BOTTOM_RIGHT
        }
        fun randomTop() = when (rand.nextInt(2)) {
            0 -> TOP
            1 -> TOP_LEFT
            else -> TOP_RIGHT
        }
        fun randomBottom() = when (rand.nextInt(2)) {
            0 -> BOTTOM
            1 -> BOTTOM_LEFT
            else -> BOTTOM_RIGHT
        }
    }
}
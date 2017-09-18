package io.github.ranolp.correctarrow.game

enum class ArrowTo(vararg val id: Int) {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3),
    TOP_LEFT(0, 2),
    BOTTOM_LEFT(0, 3),
    TOP_RIGHT(1, 2),
    BOTTOM_RIGHT(1, 3)
}
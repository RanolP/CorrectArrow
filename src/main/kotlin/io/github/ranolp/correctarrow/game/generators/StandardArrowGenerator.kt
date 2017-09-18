package io.github.ranolp.correctarrow.game.generators

import io.github.ranolp.correctarrow.game.Arrow
import io.github.ranolp.correctarrow.game.ArrowFrom
import io.github.ranolp.correctarrow.game.ArrowGenerator
import io.github.ranolp.correctarrow.game.ArrowTo
import java.util.*

class StandardArrowGenerator(vararg allowedDirections: ArrowFrom) : ArrowGenerator {
    companion object {
        val ALLOW_ALL = StandardArrowGenerator(ArrowFrom.LEFT, ArrowFrom.RIGHT, ArrowFrom.TOP, ArrowFrom.BOTTOM)
        private val RANDOM = Random()
    }

    // for remove duplicated directions.
    private val allowed = setOf(*allowedDirections)

    override fun generate(from: ArrowFrom, size: Int): List<Arrow> {
        return if (size <= 0 || from !in allowed) {
            emptyList()
        } else if (size == 1) {
            listOf(Arrow(from, when (from) {
                ArrowFrom.LEFT -> ArrowTo.RIGHT
                ArrowFrom.RIGHT -> ArrowTo.LEFT
                ArrowFrom.TOP -> ArrowTo.BOTTOM
                ArrowFrom.BOTTOM -> ArrowTo.TOP
            }))
        } else {
            val first = when (from) {
                ArrowFrom.LEFT -> if (RANDOM.nextBoolean()) ArrowTo.RIGHT else ArrowTo.BOTTOM_RIGHT
                ArrowFrom.RIGHT -> if (RANDOM.nextBoolean()) ArrowTo.LEFT else ArrowTo.BOTTOM_LEFT
                ArrowFrom.TOP -> if (RANDOM.nextBoolean()) ArrowTo.BOTTOM else ArrowTo.BOTTOM_RIGHT
                ArrowFrom.BOTTOM -> if (RANDOM.nextBoolean()) ArrowTo.TOP else ArrowTo.TOP_RIGHT
            }
            val generator = when (from) {
                ArrowFrom.LEFT -> ArrowTo.Companion::randomRight
                ArrowFrom.RIGHT -> ArrowTo.Companion::randomLeft
                ArrowFrom.TOP -> ArrowTo.Companion::randomBottom
                ArrowFrom.BOTTOM -> ArrowTo.Companion::randomTop
            }
            val last = when (from) {
                ArrowFrom.LEFT -> if (RANDOM.nextBoolean()) ArrowTo.RIGHT else ArrowTo.TOP_RIGHT
                ArrowFrom.RIGHT -> if (RANDOM.nextBoolean()) ArrowTo.LEFT else ArrowTo.TOP_LEFT
                ArrowFrom.TOP -> if (RANDOM.nextBoolean()) ArrowTo.BOTTOM else ArrowTo.BOTTOM_LEFT
                ArrowFrom.BOTTOM -> if (RANDOM.nextBoolean()) ArrowTo.TOP else ArrowTo.TOP_LEFT
            }
            List(size, { Arrow(from, if (it == 0) first else if (it == size - 1) last else generator()) })
        }
    }
}
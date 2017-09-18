package io.github.ranolp.correctarrow.game.generators

import io.github.ranolp.correctarrow.game.Arrow
import io.github.ranolp.correctarrow.game.ArrowFrom
import io.github.ranolp.correctarrow.game.ArrowGenerator
import io.github.ranolp.correctarrow.game.ArrowTo

class StandardArrowGenerator(vararg allowedDirections: ArrowFrom) : ArrowGenerator {
    companion object {
        val ALLOW_ALL = StandardArrowGenerator(ArrowFrom.LEFT, ArrowFrom.RIGHT, ArrowFrom.TOP, ArrowFrom.BOTTOM)
    }
    // for remove duplicated directions.
    private val allowed = setOf(*allowedDirections)

    override fun generate(from: ArrowFrom, size: Int): List<Arrow> {
        return if (from !in allowed) {
            emptyList()
        } else {
            val generator = when (from) {
                ArrowFrom.LEFT -> ArrowTo.Companion::randomRight
                ArrowFrom.RIGHT -> ArrowTo.Companion::randomLeft
                ArrowFrom.TOP -> ArrowTo.Companion::randomBottom
                ArrowFrom.BOTTOM -> ArrowTo.Companion::randomTop
            }
            List(size, { Arrow(from, generator()) })
        }
    }
}
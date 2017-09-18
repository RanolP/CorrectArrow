package io.github.ranolp.correctarrow.game

import io.github.ranolp.correctarrow.game.generators.StandardArrowGenerator

class Board(val height: Int, val width: Int, val generator: ArrowGenerator = StandardArrowGenerator.ALLOW_ALL) {
    val leftArrows: List<Arrow> = generator.generate(ArrowFrom.LEFT, height)
    val rightArrows: List<Arrow> = generator.generate(ArrowFrom.RIGHT, height)
    val topArrows: List<Arrow> = generator.generate(ArrowFrom.TOP, width)
    val bottomArrows: List<Arrow> = generator.generate(ArrowFrom.BOTTOM, width)
}
package io.github.ranolp.correctarrow.game

class Board(val height: Int, val width: Int, val generator: ArrowGenerator) {
    private val leftArrows: List<Arrow> = generator.generate(ArrowFrom.LEFT, height)
    private val rightArrows: List<Arrow> = generator.generate(ArrowFrom.RIGHT, height)
    private val topArrows: List<Arrow> = generator.generate(ArrowFrom.TOP, width)
    private val bottomArrows: List<Arrow> = generator.generate(ArrowFrom.BOTTOM, width)
}
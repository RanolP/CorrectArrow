package io.github.ranolp.correctarrow.game

import io.github.ranolp.correctarrow.error.BoardSizeError
import io.github.ranolp.correctarrow.game.generators.StandardArrowGenerator

class Board(val height: Int, val width: Int, val generator: ArrowGenerator = StandardArrowGenerator.ALLOW_ALL) {
    val leftArrows: List<Arrow> = generator.generate(ArrowFrom.LEFT, height)
    val rightArrows: List<Arrow> = generator.generate(ArrowFrom.RIGHT, height)
    val topArrows: List<Arrow> = generator.generate(ArrowFrom.TOP, width)
    val bottomArrows: List<Arrow> = generator.generate(ArrowFrom.BOTTOM, width)
    val numbers: MutableList<MutableList<Int>> = MutableList(height, { MutableList(width, { 0 }) })

    init {
        if (height <= 0) {
            throw BoardSizeError(false, height)
        } else if (width <= 0) {
            throw BoardSizeError(false, width)
        }
        // eval numbers. sorry for my bad code :(
        // :: LEFT
        for ((index, arrow) in leftArrows.withIndex()) {
            when (arrow.to) {
                ArrowTo.TOP_RIGHT -> {
                    var j = index - 1
                    for (i in 0 until width) {
                        if (j < 0) {
                            break
                        }
                        numbers[j--][i] += 1
                    }
                }
                ArrowTo.RIGHT -> {
                    for (i in 0 until width) {
                        numbers[index][i] += 1
                    }
                }
                ArrowTo.BOTTOM_RIGHT -> {
                    var j = index + 1
                    for (i in 0 until width) {
                        if (j >= height) {
                            break
                        }
                        numbers[j++][i] += 1
                    }
                }
                else -> {
                    /* Do nothing */
                }
            }
        }
        // :: RIGHT
        for ((index, arrow) in rightArrows.withIndex()) {
            when (arrow.to) {
                ArrowTo.TOP_LEFT -> {
                    var j = index - 1
                    for (i in (1..width).reversed()) {
                        if (j < 0) {
                            break
                        }
                        numbers[j--][i-1] += 1
                    }
                }
                ArrowTo.LEFT -> {
                    for (i in 0 until width) {
                        numbers[index][i] += 1
                    }
                }
                ArrowTo.BOTTOM_LEFT -> {
                    var j = index + 1
                    for (i in (1..width).reversed()) {
                        if (j >= height) {
                            break
                        }
                        numbers[j++][i-1] += 1
                    }
                }
                else -> {
                    /* Do nothing */
                }
            }
        }
        // :: TOP
        for ((index, arrow) in topArrows.withIndex()) {
            when (arrow.to) {
                ArrowTo.BOTTOM_LEFT -> {
                    var j = index - 1
                    for (i in 0 until height) {
                        if (j < 0) {
                            break
                        }
                        numbers[i][j--] += 1
                    }
                }
                ArrowTo.BOTTOM -> {
                    for (i in 0 until height) {
                        numbers[i][index] += 1
                    }
                }
                ArrowTo.BOTTOM_RIGHT -> {
                    var j = index + 1
                    for (i in 0 until height) {
                        if (j >= width) {
                            break
                        }
                        numbers[i][j++] += 1
                    }
                }
                else -> {
                    /* Do nothing */
                }
            }
        }
        // :: BOTTOM
        for ((index, arrow) in bottomArrows.withIndex()) {
            when (arrow.to) {
                ArrowTo.TOP_LEFT -> {
                    var j = index - 1
                    for (i in (1..height).reversed()) {
                        if (j < 0) {
                            break
                        }
                        numbers[i-1][j--] += 1
                    }
                }
                ArrowTo.TOP -> {
                    for (i in 0 until height) {
                        numbers[i][index] += 1
                    }
                }
                ArrowTo.TOP_RIGHT -> {
                    var j = index + 1
                    for (i in (1..height).reversed()) {
                        if (j >= width) {
                            break
                        }
                        numbers[i-1][j++] += 1
                    }
                }
                else -> {
                    /* Do nothing */
                }
            }
        }
    }
}
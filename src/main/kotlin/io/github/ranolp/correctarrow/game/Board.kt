package io.github.ranolp.correctarrow.game

import io.github.ranolp.correctarrow.error.BoardSizeError
import io.github.ranolp.correctarrow.game.generators.StandardArrowGenerator

class Board(val height: Int, val width: Int, val generator: ArrowGenerator = StandardArrowGenerator.ALLOW_ALL) {
    val leftArrows: List<Arrow> = generator.generate(ArrowFrom.LEFT, height)
    val rightArrows: List<Arrow> = generator.generate(ArrowFrom.RIGHT, height)
    val topArrows: List<Arrow> = generator.generate(ArrowFrom.TOP, width)
    val bottomArrows: List<Arrow> = generator.generate(ArrowFrom.BOTTOM, width)
    val numbers: MutableList<MutableList<Int>> = MutableList(height, { MutableList(width, { 0 }) })

    operator fun get(x: Int, y: Int): Int = numbers[y][x]

    operator fun set(x: Int, y: Int, value: Int) {
        numbers[y][x] = value
    }

    operator fun get(pos: Pos): Int = numbers[pos.y][pos.x]

    operator fun set(pos: Pos, value: Int) {
        numbers[pos.y][pos.x] = value
    }

    init {
        if (height <= 0) {
            throw BoardSizeError(false, height)
        } else if (width <= 0) {
            throw BoardSizeError(true, width)
        }
        // eval numbers. sorry for my bad code :(
        // :: LEFT
        for ((index, arrow) in leftArrows.withIndex()) {
            when (arrow.to) {
                ArrowTo.TOP_RIGHT -> {
                    var y = index - 1
                    for (x in 0 until width) {
                        if (y < 0) {
                            break
                        }
                        this[x, y--] += 1
                    }
                }
                ArrowTo.RIGHT -> {
                    for (x in 0 until width) {
                        this[x, index] += 1
                    }
                }
                ArrowTo.BOTTOM_RIGHT -> {
                    var y = index + 1
                    for (x in 0 until width) {
                        if (y >= height) {
                            break
                        }
                        this[x, y++] += 1
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
                    var y = index - 1
                    for (x in width - 1 downTo 0) {
                        if (y < 0) {
                            break
                        }
                        this[x, y--] += 1
                    }
                }
                ArrowTo.LEFT -> {
                    for (x in 0 until width) {
                        this[x, index] += 1
                    }
                }
                ArrowTo.BOTTOM_LEFT -> {
                    var y = index + 1
                    for (x in width - 1 downTo 0) {
                        if (y >= height) {
                            break
                        }
                        this[x, y++] += 1
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
                    var x = index - 1
                    for (y in 0 until height) {
                        if (x < 0) {
                            break
                        }
                        this[x--, y] += 1
                    }
                }
                ArrowTo.BOTTOM -> {
                    for (y in 0 until height) {
                        this[index, y] += 1
                    }
                }
                ArrowTo.BOTTOM_RIGHT -> {
                    var x = index + 1
                    for (y in 0 until height) {
                        if (x >= width) {
                            break
                        }
                        this[x++, y] += 1
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
                    var x = index - 1
                    for (y in height - 1 downTo 0) {
                        if (x < 0) {
                            break
                        }
                        this[x--, y] += 1
                    }
                }
                ArrowTo.TOP -> {
                    for (y in 0 until height) {
                        this[index, y] += 1
                    }
                }
                ArrowTo.TOP_RIGHT -> {
                    var x = index + 1
                    for (y in height - 1 downTo 0) {
                        if (x >= width) {
                            break
                        }
                        this[x++, y] += 1
                    }
                }
                else -> {
                    /* Do nothing */
                }
            }
        }
    }
}
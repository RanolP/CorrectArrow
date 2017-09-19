package io.github.ranolp.correctarrow

import io.github.ranolp.correctarrow.game.Arrow
import io.github.ranolp.correctarrow.game.ArrowFrom
import io.github.ranolp.correctarrow.game.ArrowTo
import io.github.ranolp.correctarrow.game.Board

fun main(args: Array<String>) {
    val charMap = mapOf(Arrow(ArrowFrom.LEFT, ArrowTo.RIGHT) to '→',
            Arrow(ArrowFrom.LEFT, ArrowTo.TOP_RIGHT) to '↗',
            Arrow(ArrowFrom.LEFT, ArrowTo.BOTTOM_RIGHT) to '↘',
            Arrow(ArrowFrom.RIGHT, ArrowTo.LEFT) to '←',
            Arrow(ArrowFrom.RIGHT, ArrowTo.TOP_LEFT) to '↖',
            Arrow(ArrowFrom.RIGHT, ArrowTo.BOTTOM_LEFT) to '↙',
            Arrow(ArrowFrom.TOP, ArrowTo.BOTTOM) to '↓',
            Arrow(ArrowFrom.TOP, ArrowTo.BOTTOM_LEFT) to '↙',
            Arrow(ArrowFrom.TOP, ArrowTo.BOTTOM_RIGHT) to '↘',
            Arrow(ArrowFrom.BOTTOM, ArrowTo.TOP) to '↑',
            Arrow(ArrowFrom.BOTTOM, ArrowTo.TOP_LEFT) to '↖',
            Arrow(ArrowFrom.BOTTOM, ArrowTo.TOP_RIGHT) to '↗')
    val height = 3
    val width = 3
    val board = Board(height, width)
    println(" ${board.topArrows.map(charMap::get).joinToString("")}")
    for (i in 0..height-1) {
        println("${charMap[board.leftArrows[i]]}${board.numbers[i].joinToString("")}${charMap[board.rightArrows[i]]}")
    }
    println(" ${board.bottomArrows.map(charMap::get).joinToString("")}")
}
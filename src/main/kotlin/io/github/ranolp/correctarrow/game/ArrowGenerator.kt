package io.github.ranolp.correctarrow.game

interface ArrowGenerator {
    fun generate(from: ArrowFrom, size: Int): List<Arrow>
}
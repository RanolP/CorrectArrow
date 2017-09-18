package io.github.ranolp.correctarrow.game

import io.github.ranolp.correctarrow.error.SameDirectionError

class Arrow(val from: ArrowFrom, val to: ArrowTo) {
    init {
        if(from.id in to.id) {
            throw SameDirectionError(from, to)
        }
    }
}
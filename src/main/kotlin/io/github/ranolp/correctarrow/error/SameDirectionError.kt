package io.github.ranolp.correctarrow.error

import io.github.ranolp.correctarrow.game.ArrowFrom
import io.github.ranolp.correctarrow.game.ArrowTo

class SameDirectionError(from: ArrowFrom, to: ArrowTo) : Error("Direction $from is same to $to")
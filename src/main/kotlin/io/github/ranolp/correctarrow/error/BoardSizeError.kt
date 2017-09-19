package io.github.ranolp.correctarrow.error

class BoardSizeError(horizontal: Boolean,
        num: Int) : Error("The board's size is less than zero. (in ${if (horizontal) "horizontal" else "vertical"} line, $num)")
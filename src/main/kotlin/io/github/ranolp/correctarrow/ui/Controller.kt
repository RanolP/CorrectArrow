package io.github.ranolp.correctarrow.ui

import io.github.ranolp.correctarrow.game.Board
import io.github.ranolp.correctarrow.util.toSafeInt
import javafx.fxml.FXML
import javafx.scene.control.Spinner
import javafx.util.StringConverter

class Controller {
    @FXML private lateinit var width: Spinner<Int>
    @FXML private lateinit var height: Spinner<Int>
    private lateinit var board: Board

    fun initialize() {
        val safeConverter = object : StringConverter<Int>() {
            override fun toString(int: Int?): String = int?.toString() ?: "0"

            override fun fromString(string: String?): Int = string.toSafeInt(1)
        }
        width.valueFactory.converter = safeConverter
        height.valueFactory.converter = safeConverter
    }

    fun refreshBoard() {

    }
}
package io.github.ranolp.correctarrow

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage


fun main(args: Array<String>) {
    Application.launch(CorrectArrowMain::class.java, *args)
}

class CorrectArrowMain : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(FXMLLoader.load(javaClass.getResource("../../../../../resources/design.fxml")))
        primaryStage.title = "CorrectArrow"
        primaryStage.show()
    }
}
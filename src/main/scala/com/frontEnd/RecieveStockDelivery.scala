package com.frontEnd
import com.Launcher
import com.frontEnd.MainMenu
import com.reference.GUI

import scalafx.scene.Scene
import scalafx.scene.control.{Button, PasswordField, TableColumn, TextField}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.event.ActionEvent
/**
  * Created by Administrator on 06/07/2016.
  */
class RecieveStockDelivery extends Scene {
  private val back = new Button("back")








  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }

  root = new HBox(back)
}
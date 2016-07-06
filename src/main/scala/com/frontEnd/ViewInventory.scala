package com.frontEnd
import com.Launcher
import com.reference.GUI

import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.control.TableColumn._
/**
  * Created by Administrator on 06/07/2016.
  */
class ViewInventory extends Scene {
  private val back = new Button("back")









  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }

  root = new HBox(back)
}
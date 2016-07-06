package com.frontEnd
import com.Launcher
import com.backEnd.WorkerList
import com.reference.GUI
import sun.security.util.Password

import scalafx.scene.Scene
import scalafx.scene.control.{Button, PasswordField, TextField}
import scalafx.scene.layout.VBox
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.geometry.Pos

/**
  * Created by Administrator on 06/07/2016.
  */
class Login extends Scene {
  private val username = new TextField()
  private val password = new PasswordField()
  private val submit = new Button("Submit")


  submit.onAction = (event: ActionEvent) => {

    if (WorkerList.findWorker(username.text.value).isEmpty) {

      println("Invalid login")
//TODO please add error messages in windows
    }
    else {
      val employeeObject = WorkerList.findWorker(username.text.value).head
      if (password.text.value == employeeObject.password) {
        Launcher.stage.scene = new MainMenu()
      }
      else {
        println("Invalid login")
        //TODO add error pop ups
      }
    }



  }
  private val menu = new VBox(username, password, submit)
  menu.alignment = Pos.Center
  root = menu
}

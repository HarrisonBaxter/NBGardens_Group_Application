package com

import com.frontEnd.Login

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

/**
  * Created by Harrison Baxter on 06/07/2016.
  */
object Launcher extends JFXApp {
  stage = new PrimaryStage {
    title = ""
    height = 400
    width = 400
    scene = new Login()
  }
}

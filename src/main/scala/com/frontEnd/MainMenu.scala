package com.frontEnd
import com.Launcher
import com.reference.GUI

import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.Includes._
import scalafx.scene.layout.{HBox, VBox}

/**
  * Created by Administrator on 06/07/2016.
  */
class MainMenu extends Scene {
  private val viewOrders = new Button("Orders")
  private val viewInventory = new Button("Inventory")
  private val recieveAStockDelivery = new Button("Recieve a Delivery")
  private val viewItems = new Button("View Line Items")
  private val logOut = new Button("Logout")



  viewOrders.onAction = (event: ActionEvent) =>{
    Launcher.stage.scene = new ViewOrders()
  }



  viewInventory.onAction = (event: ActionEvent) =>{
    Launcher.stage.scene = new ViewInventory()
  }


  recieveAStockDelivery.onAction = (event: ActionEvent) =>{
    Launcher.stage.scene = new RecieveStockDelivery()
  }

  viewItems.onAction = (event: ActionEvent) =>{
    Launcher.stage.scene = new ViewItems()
  }

  logOut.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new Login()
  }


  root = new VBox(viewOrders, viewInventory, recieveAStockDelivery, viewItems, logOut)
}

package com.frontEnd


import com.Launcher
import com.backEnd.{InventoryItem, Order}
import com.frontEnd.{GUIOrder, MainMenu}
import com.reference.GUISessions._
import com.reference.{GUI, OrderStatus, main1}

import scalafx.scene.Scene
import scalafx.scene.control.{TableCell, _}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.control.TableColumn._

/**
  * Created by Harrison Baxter on 11/07/2016.
  */
class ViewItems extends Scene {
  private val back = new Button("back")
  var DataList = main1.OrderListOfficial
  def chooseOrder(): Unit = {

    var checked = false

    // while (!checked) {

    val Choosedialog = new TextInputDialog(defaultValue = "E.g. 2") {
      initOwner(stage)
      title = "com.backEnd.Order Allocation"
      headerText = "What order would you like to assign to yourself?"
      contentText = "Enter order ID:"
    }

    var result = Choosedialog.showAndWait()

    result match {
      case Some(result) => choosecontinue(result.toInt)
      case None => standard
    }

    def choosecontinue(example : Int): Unit = {



      main1.updateOrderList()
      main1.decrementStock(example)

    }

  }

  def CreateOrderItembuffer (): ObservableBuffer[GUIOrderItems] = {

    val OrderBuffer = ObservableBuffer[GUIOrderItems](
    )

    for(i<- DataList(1).orderitems){//change 1 to specify what order you want
      OrderBuffer += new GUIOrderItems (i.pid, main1.Stock.findProduct(i.pid).get.name, i.quantity, i.porouswareQuantity)
    }
    OrderBuffer
  }

val table = new TableView[GUIOrderItems](CreateOrderItembuffer){
}

  var col1 = new TableColumn[GUIOrderItems, Int]("ID")
  col1.cellValueFactory = cdf => ObjectProperty(cdf.value.id)

  var col2 = new TableColumn[GUIOrderItems, String]("Name")
  col2.cellValueFactory = cdf => ObjectProperty(cdf.value.item)

  var col3 = new TableColumn[GUIOrderItems, Int]("Quantity")
  col3.cellValueFactory = cdf => ObjectProperty(cdf.value.quantity)

  var col4 = new TableColumn[GUIOrderItems, Int]("Porous Quantity")
  col4.cellValueFactory = cdf => ObjectProperty(cdf.value.porousQuantity)

table.columns ++= List(col1, col2, col3, col4)

  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }

  root = new VBox(back, table)
}

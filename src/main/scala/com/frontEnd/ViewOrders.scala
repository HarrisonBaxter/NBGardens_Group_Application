package com.frontEnd

import com.Launcher
import com.backEnd.{InventoryItem, Order}
import com.frontEnd.{GUIOrder, MainMenu}
import com.reference.{GUI, main1}

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
  * Created by Administrator on 06/07/2016.
  */
class ViewOrders extends Scene {
  private val back = new Button("back")
  var DataList = main1.OrderListOfficial

  def CreateOrderbuffer (): ObservableBuffer[Order] = {

    val OrderBuffer = ObservableBuffer[Order](
    )

    for(i<- DataList){
      OrderBuffer += new Order(i.id, i.status, i.orderitems)

    }
    OrderBuffer
  }

  var table = new TableView[Order](CreateOrderbuffer) {
  }
  val col1 = new TableColumn[Order, Int]("ID")
  col1.cellValueFactory = cdf => ObjectProperty(cdf.value.id)

  val col2 = new TableColumn[Order, Enum]("Status")
  col2.cellValueFactory = cdf => ObjectProperty(cdf.value.status)

  val ccl3 = new TableColumn[Order, ObservableBuffer]("Order Lines")
  ccl3.cellValueFactory = cdf => ObjectProperty(cdf.value.orderitems)
  table.columns ++= List(col1, col2, ccl3)

  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }

  root = new VBox(back, table)
}


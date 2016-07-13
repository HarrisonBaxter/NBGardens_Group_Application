package com.frontEnd

import com.{Launcher, backEnd}
import com.backEnd.{DataDump, InventoryItem, Order, OrderLine}
import com.frontEnd.{GUIOrder, MainMenu}
import com.reference.GUISessions._
import com.reference.{GUI, Inventory, OrderStatus, main1}
import jdk.internal.org.objectweb.asm.tree.analysis.Value

import scala.collection.mutable.ArrayBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{TableCell, _}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.collections
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.control.TableColumn._

/**
  * Created by Administrator on 06/07/2016.
  */
class ViewOrders extends Scene {
  private val back = new Button("back")
  private val assignTo = new Button("Assign")
  var DataList = main1.OrderListOfficial
  var orderLineItems = new ArrayBuffer[OrderLine]
  var myBuffer: ObservableBuffer[InventoryItem] = ObservableBuffer.empty









  def CreateOrderbuffer(): ObservableBuffer[Order] = {

    val OrderBuffer = ObservableBuffer[Order](
    )

    for (i <- DataList) {
      OrderBuffer += new Order(i.id, i.status, i.orderitems)

    }
    OrderBuffer
  }

  var table = new TableView[Order](CreateOrderbuffer) {
  }

  val col1 = new TableColumn[Order, Int]("ID")
  col1.cellValueFactory = cdf => ObjectProperty(cdf.value.id)

  val col2 = new TableColumn[Order, String]("Status")
  col2.cellValueFactory = cdf => ObjectProperty(cdf.value.status.toString)

  val col3 = new TableColumn[Order, String]("Line")
  col3.cellValueFactory = cdf => ObjectProperty(cdf.value.orderitems.mkString) //(0).pid.toString)

  table.columns ++= List(col1, col2, col3)

  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }
  assignTo.onAction = (event: ActionEvent) => {
    chooseOrder()
  }


  root = new VBox(back, table, assignTo)

  table.selectionModel.apply.selectedItems.onChange(
    println("selected" + table.selectionModel.apply.getSelectedItem)
  )
}


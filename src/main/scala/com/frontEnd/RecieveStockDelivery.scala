package com.frontEnd
import com.Launcher
import com.backEnd.{PurchaseOrder, PurchaseOrderStatus}
import com.frontEnd.MainMenu
import com.reference.{GUI, OrderStatus}

import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.input.MouseEvent
/**
  * Created by Administrator on 06/07/2016.
  */
class RecieveStockDelivery extends Scene {
  private val back = new Button("back")
  var stockDeliveries = PurchaseOrder.purchaseOrders
  def CreateDeliveryBuffer :ObservableBuffer[PurchaseOrder] = {

    val deliveryBuffer = ObservableBuffer[PurchaseOrder](
    )

    for(i<- stockDeliveries){

      deliveryBuffer += new PurchaseOrder(i.dId, i.dtMade, i.sup, i.status, i.dtDelivered )

    }
    deliveryBuffer
  }


var table = new TableView[PurchaseOrder](CreateDeliveryBuffer)

  var col1 = new TableColumn[PurchaseOrder, Int]("Purchase Order ID")
  col1.cellValueFactory = cdf => ObjectProperty(cdf.value.dId)

  var col2 = new TableColumn[PurchaseOrder, String]("Date Ordered")
  col2.cellValueFactory = cdf => StringProperty(cdf.value.dtMade)

  var col3 = new TableColumn[PurchaseOrder, String]("Company")
  col3.cellValueFactory = cdf => StringProperty(cdf.value.sup)

  var col4 = new TableColumn[PurchaseOrder, PurchaseOrderStatus.Value]("Status")
  col4.cellValueFactory =  cdf => ObjectProperty(cdf.value.status)

  var col5 = new TableColumn[PurchaseOrder, String]("Date Delivered")
  col5.cellValueFactory = cdf => StringProperty(cdf.value.dtDelivered)

  table.onMouseClicked = (event: MouseEvent) => {
    println(table.getSelectionModel.getSelectedItem.dId)
  }


  table.columns ++= List(col1, col2, col3, col4, col5)

  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }

  root = new VBox(back, table)

  def doDialog() : Unit = {
    val choices = PurchaseOrderStatus.values.toSet

    val dialog = new ChoiceDialog(defaultChoice = PurchaseOrderStatus.Ordered, choices = choices) {
      title = "Order Status"
      headerText = "Set the status of the order"
      contentText = "Choose status"
    }

    val result = dialog.showAndWait()

    result match {
      case Some(choice) => println("Choice" + choice)
      case _ => println("No Selection")
    }
  }
}
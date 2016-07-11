package com.frontEnd
import com.Launcher
import com.backEnd.InventoryItem

import scalafx.collections.ObservableBuffer


import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.control.TableColumn._
import scalafx.stage.Stage
import scalafx.beans.property._
/**
  * Created by Administrator on 06/07/2016.
  */
class ViewInventory extends Scene {
  private val back = new Button("back")

  var data = InventoryItem.inventoryItems


  def CreateInventoryBuffer (): ObservableBuffer[InventoryItem] = {

    val OrderBuffer = ObservableBuffer[InventoryItem](
    )

    for(i<- data){
      OrderBuffer += new InventoryItem(i.id, i.name, i.quantity, i.porouswareQuantity, i.location)

    }
    OrderBuffer
  }


  var table = new TableView[InventoryItem](CreateInventoryBuffer) {
  }
  val col1 = new TableColumn[InventoryItem, String]("Name")
  col1.cellValueFactory = cdf => ObjectProperty(cdf.value.name)

  val col2 = new TableColumn[InventoryItem, Int]("ID")
  col2.cellValueFactory = cdf => ObjectProperty(cdf.value.id)

  val col3 = new TableColumn[InventoryItem, Int]("Quantity")
  col3.cellValueFactory = cdf => ObjectProperty(cdf.value.quantity)

  val col4 = new TableColumn[InventoryItem, Int]("Porousware Quantity")
  col4.cellValueFactory = cdf => ObjectProperty(cdf.value.porouswareQuantity)

  val col5 = new TableColumn[InventoryItem, Double]("Location")
  col5.cellValueFactory = cdf => ObjectProperty(cdf.value.location)

  table.columns ++= List(col1, col2, col3, col4, col5)


  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }


  root = new VBox(back, table)











}
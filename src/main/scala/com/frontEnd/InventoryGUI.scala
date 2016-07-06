package com.frontEnd

import com.backEnd.DataDump
import com.reference.main1

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control._



class InventoryGUI extends JFXApp {
  var DataList = DataDump.getInventory

  def CreateStockBuffer (): ObservableBuffer[GUIStock] = {

    val StockBuffer = ObservableBuffer[GUIStock](
    )
    for (i <- main1.StockListOfficial) {
      StockBuffer += new GUIStock((i).id.toString, (i).name.toString, (i).quantity.toString, (i).porouswareQuantity.toString, (i).location.toString)

    }
    StockBuffer
  }
  def PrintStockList(): Unit = {

    stage = new PrimaryStage {
      title = "TableView with custom color cell"
      scene = new Scene {
        //gets buffer from CreateOrderbuffer method
        content = new TableView[GUIStock](CreateStockBuffer) {
          columns ++= List(
            new TableColumn[GUIStock, String] {
              text = "Stock ID"
              cellValueFactory = {_.value.ID}
              prefWidth = 100
            })
          new TableColumn[GUIStock, String]() {
            text = "Name"
            cellValueFactory = {_.value.Name}
            prefWidth = 100
          }
          new TableColumn[GUIStock, String] {
            text = "Quantity"
            cellValueFactory = {_.value.Quantity}
            prefWidth = 100
          }
          new TableColumn[GUIStock, String] {
            text = "Porousware Quantity"
            cellValueFactory = {_.value.PorousQuantity}
            prefWidth = 100
          }
          new TableColumn[GUIStock, String] {
            text = "Location"
            cellValueFactory = {_.value.Location}
            prefWidth = 100
          }

        }
      }
    }
  }
}

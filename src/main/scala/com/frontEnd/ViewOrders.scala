package com.frontEnd

import com.Launcher
import com.frontEnd.{GUIOrder, MainMenu}
import com.reference.{GUI, main1}

import scalafx.scene.Scene
import scalafx.scene.control.{TableCell, _}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.control.TableColumn._
/**
  * Created by Administrator on 06/07/2016.
  */
class ViewOrders extends Scene {
  private val back = new Button("back")
  var DataList = main1.OrderListOfficial

  /*def CreateOrderbuffer(): ObservableBuffer[GUIOrder] = {

    val OrderBuffer = ObservableBuffer[GUIOrder](
    )

    for (i <- DataList) {
      OrderBuffer += new GUIOrder((i).id.toString, (i).status.toString)

    }
    OrderBuffer
  }*/


 new TableView[GUIOrder] {
          columns ++= List(
            new TableColumn[GUIOrder, String] {
              text = "Order ID"
              cellValueFactory = {
                _.value.ID
              }
              prefWidth = 100
            },
            new TableColumn[GUIOrder, String]() {
              text = "status"
              cellValueFactory = {
                _.value.Status
              }
              prefWidth = 100
            },
            new TableColumn[GUIOrder, String] {
              text = "Login"
              cellValueFactory = {
                _.value.Status
              }

            } //column containing buttons on each row, contained within a TableCell
          )

        }








  back.onAction = (event: ActionEvent) => {
    Launcher.stage.scene = new MainMenu()
  }

  root = new HBox(back)
}


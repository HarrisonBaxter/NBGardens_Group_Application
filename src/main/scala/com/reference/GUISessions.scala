package com.reference

import scalafx.application.JFXApp
import scalafx.scene.control.{ChoiceDialog, TextInputDialog}

/**
  * Created by Administrator on 28/06/2016.
  */

object GUISessions extends JFXApp {


  def standard () : Unit = {
    val choices = Seq("Check order list", "Choose/pick order","Check order items")

    val dialog = new ChoiceDialog(defaultChoice = "Check order list", choices = choices) {
      initOwner(stage)
      title = "Session Menu"
      headerText = "What would you like to do?"
      contentText = "Choose an option:"
    }

    val result = dialog.showAndWait()

    result match {
//      case Some("Check order list") => GUI.PrintOrderList
      case Some("Choose/pick order") => chooseOrder
//      case Some("Check order items") => GUI.PrintOrder_items
      case None => println("No selection1")
        GUI.onShowLoginDialog()
    }
    GUI.onShowLoginDialog()
  }

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

    }

    def choosecontinue(example : Int): Unit = {
      if (main1.OrderListOfficial(example - 1).status != OrderStatus.Allocated) {
        checked = true
      } else {
        println("com.backEnd.Order has already been allocated!!! choose another order")
      }

      main1.OrderList1.orderAllocation(example-1)

      main1.decrementStock(example)
      main1.updateOrderList()
    }

    // }
  }
}

package com.reference

import com.backEnd.{OrderList, PurchaseOrderList}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Paul on 03/07/2016.
  */
class OrderManager {
  var OrderList1 = new OrderList()

  var Stock = Inventory()

  var StockListOfficial = Stock.getInventoryList()
  var OrderListOfficial = OrderList1.getOrderList
  var purchaseOrders = new PurchaseOrderList

  def OrderManager(): Unit = {

    var selection = ""
    var finished = false

    while (!finished) {
      println("Stock manager")
      println()
      printOrders()
      println()
      print("Enter order number you wish to manage (choose any to proceed to menu and quit)  : ")

      var ConsoleInput: Int = scala.io.StdIn.readInt()
      ConsoleInput -= 1

      // = ArrayBuffer(OrderList1.getOrderList)

      selection = OrderList1.printListIndividual(ConsoleInput, Stock)
      println("You have selected : " + selection)
      println("What do you want to do with this order? : ")
      println
      println("Option 1 : Mark as shipped")
      println("Option 2 : Add new order")
      println("Option 3 : Mark as delivered")
      println("Press 4 : To quit")
      print(": ")

      val option = scala.io.StdIn.readLine()

      option match {
        case "1" => shipItem(ConsoleInput) //SHOULD CHECK IF IT HAS BEEN ALLOCATED FIRST
        case "2" => createOrder()
        case "3" => deliverItem(ConsoleInput) //SHOULD CHECK IF IT HAS BEEN SHIPPED FIRST
        case "4" => finished = true

        case _ => println("invalid option")
      }
    }
  }

  def updateOrderList(): Unit = OrderListOfficial = OrderList1.getOrderList

  def createOrder(): Unit = {

    val newID = OrderListOfficial.last.id + 1
    //      print("Select item : ")
    //      var newItem = scala.io.StdIn.readLine() //check item exists
    //      print("Select Quantity : ")
    //      val quantity: Int = scala.io.StdIn.readInt() //check item in stock
    //      print("com.backEnd.Order name : ")
    //      val newObject: String = scala.io.StdIn.readLine()

    OrderList1.addOrder(newID, OrderStatus.Ordered, ArrayBuffer())
    updateOrderList()
    println("com.backEnd.Order created")

  }

  def shipItem(ItemID: Int): Unit = {

    OrderList1.markedShipped(ItemID)
    updateOrderList()
  }

  def deliverItem(ItemID: Int): Unit = {

    OrderList1.markedDelivered(ItemID)
    updateOrderList()
  }

  def printOrders(): Unit = {

    OrderList1.printList(Stock)
  }

}

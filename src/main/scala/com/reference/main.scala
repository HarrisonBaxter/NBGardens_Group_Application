package com.reference

/**
  * Created by MacZ on 16/06/2016.
  */
import com.backEnd.{DataDump, OrderList, PurchaseOrderList, WorkerList}

import scala.Array._
import scala.collection.mutable.{ArrayBuffer, Stack}
import scalafx.collections.ObservableBuffer

//small changed changed again via VM
object main1 {

  val workerList = DataDump.getWorkers
  var currentWorker = WorkerList(null,null)

  var OrderList1 = new OrderList()
  var Stock = Inventory()

  var StockListOfficial = Stock.getInventoryList()
  var OrderListOfficial = OrderList1.getOrderList
  var purchaseOrders = new PurchaseOrderList


  //OrderListOfficial
  var valid = false
  var continue = false

  def main(args: Array[String]) {

    while (!valid) {
      continue = false
//      var input = ""
//      var option = ""
      var accountType = ""
//      var wrkerList = Array()

      printWorkers()

      println("Please login")
      println("Username : ")
      val ConsoleInputU = scala.io.StdIn.readLine()
      println("Password : ")
      val ConsoleInputP = scala.io.StdIn.readLine()

      val confirm = checkWorker(ConsoleInputU, ConsoleInputP)

      println(confirm)
      println

      accountType = accountTypeCheck()

      if (continue) {
        if (accountType == "admin") {
          println()
          println("Admin session activated")
          adminSession()
        } else {
          println()
          println("Standard session activated")
          session()
        }
      }

      //input = ConsoleInput.toLowerCase()
      //printList()

    }
  }


  def session(): Unit = {
    valid = false
    var finished = false

    while (!finished) {
      println("Pick an option : ")
      println()
      println("Press 1 : Check order list")
      println("Press 2 : Choose/pick order")
      println("Press 3 : View orders with order items")
      println("Press 4 : Receive a Stock Delivery")
      println("Press 5 : To quit")
      val option = scala.io.StdIn.readLine()

      option match {
        case "1" => println("Checking Orders...")
          printOrders()
        case "2" => chooseOrder()

        case "3" => OrderList1.viewOrderItems(Stock)
        case "4" =>
          val sdId = scala.io.StdIn.readLine("What is the id of the stock delivery").toInt
          val date = scala.io.StdIn.readLine("What is the date of the stock delivery")
          purchaseOrders.processDelivery(Stock, sdId, date)

        case "5" => finished = true

        case _ => println("invalid option")
      }

    }
  }

  def chooseOrder(): Unit = {
    var orderID = 0
    var checked = false
    while (!checked) {
      println("com.backEnd.Order allocation\n")
      printOrders()
      print("\nEnter order number you wish to choose : ")
      orderID = scala.io.StdIn.readInt()

      if (OrderListOfficial(orderID).status != OrderStatus.Allocated) {
        checked = true
      } else {
        println("com.backEnd.Order has already been allocated!!! choose another order")
      }
    }
    println("You have selected order  " + orderID)
    decrementStock(orderID)
    OrderList1.orderAllocation(orderID-1)
    updateOrderList()

  }

  def adminSession(): Unit = {

    valid = false
    var finished = false


    while (!finished) {
      println("Pick an option : ")
      println()
      println("Press 1 : Check order list")
      println("Press 2 : Manage orders")
      println("Press 3 : View com.reference.Inventory")
      println("Press 4 : To quit")
      val option = scala.io.StdIn.readLine()

      option match {
        case "1" => println("Checking stock...")
          printOrders()
        case "2" => OrderManager() //finish
        case "3" => printInventory()
        case "4" => finished = true

        case _ => println("invalid option")
      }

    }

  }

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

  }

  def printWorkers(): Unit = {

    for (i <- workerList) {
      println(i)
    }
  }

  def checkWorker(inputUser: String, inputPass: String): String = {

    var response = ""
    //for (i <- 0 to (list.length - 1)) {
    for (item <- workerList) {

      if (item.userName.toLowerCase() == inputUser.toLowerCase()) {


        if (item.password.toLowerCase() == inputPass.toLowerCase()) {

          response = "Account confirmed, Welcome " + item.userName
          currentWorker = WorkerList(item.userName, item.password)
          valid = true
          continue = true
        }
        else {

          response = "Invalid entry, please check and try again"

        }

      } else if (item.userName.toLowerCase() != inputUser.toLowerCase()) {
        response = "Invalid entry, please check and try again"
      }
    }

    response
  }

  def printOrders(): Unit = {

    OrderList1.printList(Stock)
  }

  def printInventory(): Unit = {
    println("Current stock")
    Stock.printList()
  }

  def accountTypeCheck(): String = {
    val neededString = currentWorker.toString() //gets String of current worker for processing later
    val accountType = neededString(0) //gets account type String to use later


    accountType.toString //returns current account type
  }

  def updateOrderList(): Unit = OrderListOfficial = OrderList1.getOrderList




  def decrementStock(example: Int): Unit = {

    OrderListOfficial = OrderList1.getOrderList
    //StockListOfficial = Stock.getInventoryList()

    val order = OrderList1.findOrder(example).get

      for (i <- order.orderitems) {

        val deduction = i.quantity
        val porouswareDeduction = i.porouswareQuantity
        Stock.decrementStock(i.pid, deduction, porouswareDeduction)
      }
  }



  //Travelling salesman attempt not finished
  def Travelling(): Unit = {
    var numberOfNodes = 0
    val ints = Stack[Int]()
    var dst = 0
    var adjacencyMatrix = ofDim[Int](100, 100)

    tsp(adjacencyMatrix)

    def tsp(adjacencyMatrix: Array[Array[Int]]): Unit = {

      numberOfNodes = adjacencyMatrix(1).length - 1
      val visited = Array(numberOfNodes + 1)
      visited(1) = 1
      ints.push(1)
      var element: Int = 0
      var min: Int = Int.MaxValue
      var minFlag: Boolean = false
      print(1 + "\t")

      while (ints.nonEmpty) {

        element = ints.top
        var i: Int = 1
        min = Int.MaxValue

        while (i <= numberOfNodes) {
          if (adjacencyMatrix(element)(i) > 1 && visited(i) == 0) {
            if (min > adjacencyMatrix(element)(i)) {
              min = adjacencyMatrix(element)(i)
              dst = i
              minFlag = true
            }
          }
          i += 1
        }
        if (minFlag) {
          visited(dst) = 1
          ints.push(dst)
          println(dst + "\t")
          minFlag = false
          return
        }
        ints.pop()
      }
    }

    def main_test(): Unit = {

      var number_of_nodes: Int = 0

      println()
      print("Enter amount of items : ")
      number_of_nodes = scala.io.StdIn.readInt()
      var adjacency_Matrix = ofDim[Int](numberOfNodes + 1, numberOfNodes + 1)

      println()
      print("Enter matrix")
      for (i <- 1 to number_of_nodes)
      {
        for (j <- 1 to number_of_nodes)
        {
          adjacency_Matrix(i)(j) = scala.io.StdIn.readInt()
        }
      }
      for (i <- 1 to number_of_nodes)
      {
        for (j <- 1 to number_of_nodes)
        {
          adjacency_Matrix(j)(i) = 1
        }
      }
    }
    println("as follows")

  }

}

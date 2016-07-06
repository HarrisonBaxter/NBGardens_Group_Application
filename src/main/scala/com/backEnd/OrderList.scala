package com.backEnd

import com.reference.{Inventory, OrderStatus}

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
/**
  * Created by MacZ on 16/06/2016.
  */
class OrderList(){

  var list = DataDump.getOrders

  def findOrder(id:Int) = list.find(_.id == id)

  def viewOrderItems(products: Inventory): Unit = {

    for (order <- list) {
      println(s"ORDER ${order.id} ITEMS\n------------------\n")
      for (i <- order.orderitems) {
        println("ProductID:\t" + i.pid + "\nProduct Name: " + products.findProduct(i.pid).get.name + "\nQuantity:\t" + i.quantity + "\nPorousware Quantity:\t" + i.porouswareQuantity+"\n------------------\n")

      }
    }
  }
  def printList(products: Inventory): Unit = {


    for (i <- list.indices ){
      println("com.backEnd.Order ID : " + list(i).id + " | Status : " + list(i).status)
    }
  }

  def printListIndividual(i: Int, products: Inventory): String = {


    var ind = list(i)

    "ID : " + list(i).id + " | Item: " + products.findProduct(list(i).id).get.name + " | Status : " + list(i).status

  }

  def getOrderList: ArrayBuffer[Order] = {
    list
  }

  def addOrder(ID: Int, Status : OrderStatus.Value, ab: ArrayBuffer[OrderLine]): Unit = {

    list += Order(ID,  Status, ab)

  }

  def orderAllocation(input: Int): Unit = {

    list(input).status = OrderStatus.Allocated
  }

  def markedShipped(itemID : Int): Unit = {

    list(itemID).status = OrderStatus.Shipped
  }

  def markOrdered(itemID : Int): Unit = {

    list(itemID).status = OrderStatus.Ordered
  }

  def markedDelivered(itemID : Int): Unit = {

    list(itemID).status = OrderStatus.Delivered
    removeOrder(itemID)
  }

  def removeOrder(itemID : Int): Unit = {

    val delete = Future  {
      Thread.sleep(5000)
      println("")
    }
    delete onSuccess {
      case f =>
        list -= list(itemID)
        println("com.backEnd.Order " + itemID + " deleted")
    }
    println("Deleting")
  }


}

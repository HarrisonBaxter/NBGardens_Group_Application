package com.backEnd

import com.reference.OrderStatus

import scala.collection.mutable.ArrayBuffer

/**
  * Created by MacZ on 15/06/2016.
  */
case class Order (id: Int, var status : OrderStatus.Value, var orderitems: ArrayBuffer[OrderLine]){

  def addOrderLineItem(ol: OrderLine): Unit = {
    orderitems += ol
  }

  def getOrderItems(): Unit = {
    for (i <- this.orderitems) {
      println(s"ORDER ${this.id} ITEMS\n------------------\nProductID:\t" + i.pid + "\nQuantity:\t" + i.quantity + "\nPorousware Quantity:\t" + i.porouswareQuantity+"\n------------------\n")


    }
  }
}

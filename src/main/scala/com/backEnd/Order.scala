package com.backEnd

import com.reference.OrderStatus

import scala.collection.mutable.ArrayBuffer
import scalafx.collections.ObservableBuffer

/**
  * Created by MacZ on 15/06/2016.
  */
case class Order(id: Int, status: OrderStatus.Value, orderitems: ArrayBuffer[OrderLine]) {

  def decrementStock(example: Int): Unit ={

  }
}

object Order {

  var orders:ArrayBuffer[Order] = DataDump.getOrders

//  def addOrderLineItem(ol: OrderLine): Unit = {
//    orderitems += ol
//  }

//  def findById(id: Int) = orderitems.find(_.pid == id)


//  def getOrderItems(): Unit = {
//    for (i <- this.orderitems) {
//      println(s"ORDER ${this.id} ITEMS\n------------------\nProductID:\t" + i.pid + "\nQuantity:\t" + i.quantity + "\nPorousware Quantity:\t" + i.porouswareQuantity + "\n------------------\n")
//
//
//    }
//  }
//}

//object Order{
//  var myOrders = ArrayBuffer(Order(1,OrderStatus.Ordered, ArrayBuffer(ol1,ol17)),
//  Order(2, OrderStatus.Ordered, ArrayBuffer(ol2,ol3)),
//  Order(3, OrderStatus.Ordered, ArrayBuffer(ol4,ol16, ol24, ol25)),
//  Order(4, OrderStatus.Ordered, ArrayBuffer(ol5)),
//  Order(5, OrderStatus.Ordered, ArrayBuffer(ol6, ol18)),
//  Order(6, OrderStatus.Ordered, ArrayBuffer(ol7)),
//  Order(7, OrderStatus.Ordered, ArrayBuffer(ol8)),
//  Order(8, OrderStatus.Ordered, ArrayBuffer(ol9)),
//  Order(9, OrderStatus.Ordered, ArrayBuffer(ol10, ol26)),
//  Order(10, OrderStatus.Ordered, ArrayBuffer(ol11, ol22, ol23, ol27)),
//  Order(11, OrderStatus.Ordered, ArrayBuffer(ol12)),
//  Order(12, OrderStatus.Ordered, ArrayBuffer(ol13)),
//  Order(13, OrderStatus.Ordered, ArrayBuffer(ol14, ol19, ol20)),
//  Order(14, OrderStatus.Ordered, ArrayBuffer(ol15, ol21)))
//
}

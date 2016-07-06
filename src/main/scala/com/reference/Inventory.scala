package com.reference

import com.backEnd.{DataDump, InventoryItem}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by MacZ on 17/06/2016.
  */
case class Inventory () {
  //stuff

  var list = DataDump.getInventory

  def findProduct(id:Int) = list.find(_.id == id)


  def printList(): Unit = {

    //for (i<- 0 to (list.length - 1) ){
    for (i <- list.indices ){
      val prod = list(i)
      println("ID : " + prod.id + " | Item: " + prod.name + " | Quantity : " + prod.quantity)
    }
  }

  def printListIndividual(input: Int): String = {

    val prod  = list(input)
    "ID : " + prod + " | Item: " + prod.name + " | Quantity : " + prod.quantity
  }

  def getInventoryList(): ArrayBuffer[InventoryItem] = {

    list
  }


  def decrementStock(orderID: Int, deduction: Int, porouswareDeduction: Int): Unit = {

    val item = this.findProduct(orderID).get
    item.quantity -= deduction
    item.porouswareQuantity -= porouswareDeduction
  }


  def printProductInfo(){
    val productList = list.toList
    val sorted: List[InventoryItem] = productList.sortBy(_.id)

    for (prod <- sorted){
      println ("ProductID: " + prod.id + ", Name: " + prod.name + ", Quantity: " + prod.quantity + ", Porousware Quantity: " + prod.porouswareQuantity)
    }
  }

  def printProductInfo2(stock: Inventory){

    for (prod <- stock.getInventoryList()){
      println ("ProductID: " + prod.id + ", Name: " + prod.name + ", Quantity: " + prod.quantity + ", Porousware Quantity: " + prod.porouswareQuantity)
    }
  }


  def incrementStock(itemID: Int, increase: Int): Unit = {
    var product = this.findProduct(itemID).get
    product.quantity += increase

  }




}

package com.backEnd

import com.reference.Inventory

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 30/06/2016.
  */
case class PurchaseOrderList() {

  var purchaseOrders = DataDump.getPurchaseOrders
  val stockPurchaseItems = DataDump.getPurchaseOrderItems

  //Methods
  def findPoById(spId:Int) = purchaseOrders.find(_.dId == spId)

  //method to receive the new stock by finding the stock purchase object and updating it
  def updateStockPurchase(stockPurchase: PurchaseOrder): Unit = {
    purchaseOrders -= (findPoById(stockPurchase.dId).get)
    purchaseOrders += stockPurchase
  }

  def findAllItemsInPO(poId: Int): ArrayBuffer[PurchaseOrderLineItem] = stockPurchaseItems.filter(_.poId == poId)


  def addNewStockPurchase(newSP: PurchaseOrder): Unit ={
    purchaseOrders += newSP
  }

  def printAllStockPurchases(): Unit ={
    for (s <- purchaseOrders){
      println ("StockPurchaseID: " + s.dId + ", Status: " + s.sta + ", Date Delivered: " + s.dtDelivered)
    }
  }


  def processDelivery(stock:Inventory, delId:Int, date:String){
    //Stock Purchase status needs to be updated to Delivered with a date/time inputted
    val sp = findPoById(delId)
    updateStockPurchase(PurchaseOrder(sp.get.dId, sp.get.dtMade, sp.get.sup, "Delivered", date))

    //each inventory item quantity needs to be incremented as per purchase order/delivery
    val productList: List[InventoryItem] = stock.list.toList
    var items: ArrayBuffer[PurchaseOrderLineItem] = this.findAllItemsInPO(delId)

    for (p <- items){
      //stock quantities incremented
      stock.incrementStock(p.pid, p.quantity)
    }

    val sp2 = findPoById(delId)
    println{"StockPurchaseID: " + sp2.get.dId + ", Date Made: " + sp2.get.dtMade + ", Supplier: " +  sp2.get.sup + ", Status: " + sp2.get.sta + ", Date Delivered: " +  sp2.get.dtDelivered}

    stock.printProductInfo2(stock)
  }



  def printProductInfo(inventory:Inventory){

    val productList = inventory.list.toList
    val sorted: List[InventoryItem] = productList.sortBy(_.id).toList

    for (prod <- sorted){
      println ("ProductID: " + prod.id + ", Name: " + prod.name + ", Quantity: " + prod.quantity)
    }
  }



}


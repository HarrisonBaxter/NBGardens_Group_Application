package com.backEnd

import com.reference.{OrderStatus, Worker}

/**
  * Created by Mark K on 30/06/2016.
  */
object DataDump {
  import scala.collection.mutable.ArrayBuffer

  //A list of users which can use the system



  def getOrders: ArrayBuffer[Order] = {

    val ol1 = OrderLine(910, 10, 0)
    val ol2 = OrderLine(901, 5, 5)
    val ol3 = OrderLine(902, 1, 1)
    val ol4 = OrderLine(920, 4, 0)
    val ol5 = OrderLine(919, 1, 0)
    val ol6 = OrderLine(918, 1, 0)
    val ol7 = OrderLine(918, 2, 0)
    val ol8 = OrderLine(904, 1, 1)
    val ol9 = OrderLine(916, 2, 0)
    val ol10 = OrderLine(909, 1, 0)
    val ol11 = OrderLine(903, 1, 1)
    val ol12 = OrderLine(911, 1, 0)
    val ol13 = OrderLine(916, 1, 1)
    val ol14 = OrderLine(901, 2, 2)
    val ol15 = OrderLine(909, 5, 0)
    val ol16 = OrderLine(917, 2, 2)
    val ol17 = OrderLine(920, 5, 0)
    val ol18 = OrderLine(914, 1, 1)
    val ol19 = OrderLine(915, 1, 1)
    val ol20 = OrderLine(905, 1, 1)
    val ol21 = OrderLine(908, 2, 0)
    val ol22 = OrderLine(902, 1, 1)
    val ol23 = OrderLine(915, 1, 1)
    val ol24 = OrderLine(909, 1, 0)
    val ol25 = OrderLine(916, 1, 1)
    val ol26 = OrderLine(901, 2, 2)
    val ol27 = OrderLine(910, 2, 0)

    val order1  = Order(1,OrderStatus.Ordered, ArrayBuffer(ol1,ol17))
    val order2  = Order(2, OrderStatus.Ordered, ArrayBuffer(ol2,ol3))
    val order3  = Order(3, OrderStatus.Ordered, ArrayBuffer(ol4,ol16, ol24, ol25))
    val order4  = Order(4, OrderStatus.Ordered, ArrayBuffer(ol5))
    val order5  = Order(5, OrderStatus.Ordered, ArrayBuffer(ol6, ol18))
    val order6  = Order(6, OrderStatus.Ordered, ArrayBuffer(ol7))
    val order7  = Order(7, OrderStatus.Ordered, ArrayBuffer(ol8))
    val order8  = Order(8, OrderStatus.Ordered, ArrayBuffer(ol9))
    val order9  = Order(9, OrderStatus.Ordered, ArrayBuffer(ol10, ol26))
    val order10 = Order(10, OrderStatus.Ordered, ArrayBuffer(ol11, ol22, ol23, ol27))
    val order11 = Order(11, OrderStatus.Ordered, ArrayBuffer(ol12))
    val order12 = Order(12, OrderStatus.Ordered, ArrayBuffer(ol13))
    val order13 = Order(13, OrderStatus.Ordered, ArrayBuffer(ol14, ol19, ol20))
    val order14 = Order(14, OrderStatus.Ordered, ArrayBuffer(ol15, ol21))

     ArrayBuffer(
      order1,order2,order3,order4,order5,order6,order7,order8,order9,order10,order11,order12,order13,order14
    )
  }

  def getInventory: ArrayBuffer[InventoryItem] ={

    ArrayBuffer(InventoryItem(901, "Angry Gnome", 35, 15, 11.20),
      InventoryItem(902, "Grebe Gnome", 13, 9, 10.90),    InventoryItem(903, "Sunglasses Gnome", 21, 11, 12.10),
      InventoryItem(904, "Fishing Gnome", 32, 16, 14.00), InventoryItem(905, "Mechanic Gnome", 29, 16, 15.70),
      InventoryItem(906, "Sexy Gnome", 30, 14, 18.30),    InventoryItem(907, "Hologram Gnome", 24, 10, 11.0),
      InventoryItem(908, "Wooden Deck Chairs", 45, 0, 2), InventoryItem(909, "Sunshine Umbrella", 56, 0, 1.10),
      InventoryItem(910, "Water Bottles", 120, 0, 1.0),   InventoryItem(911, "Dragon Gnome", 19, 10, 14.20),
      InventoryItem(912, "Sailor Gnome", 27, 12, 16.90),  InventoryItem(913, "Suit Gnome", 28, 16, 12.10),
      InventoryItem(914, "Casual Gnome", 38, 12, 9.90),   InventoryItem(915, "Police Gnome", 26, 14, 8.70),
      InventoryItem(916, "Firefighter Gnome", 34, 17, 9.30), InventoryItem(917, "Doctor Gnome", 24, 22, 8.90),
      InventoryItem(918, "Hammock", 31, 0, 3.10),         InventoryItem(919, "Wheel Barrow", 29, 0, 4.10),
      InventoryItem(920, "Sprinkler", 25, 0, 5.60))
  }

  def getPurchaseOrderItems: ArrayBuffer[PurchaseOrderLineItem] = {

    ArrayBuffer(PurchaseOrderLineItem(1, 901, 12), PurchaseOrderLineItem(1, 902, 10), PurchaseOrderLineItem(1, 903, 24), PurchaseOrderLineItem(1, 904, 30),
      PurchaseOrderLineItem(2, 901, 12), PurchaseOrderLineItem(2, 905, 10), PurchaseOrderLineItem(2, 906, 24), PurchaseOrderLineItem(2, 907, 30))
  }


  def getPurchaseOrders: ArrayBuffer[PurchaseOrder] = {

    ArrayBuffer(
                      PurchaseOrder(1, "16 JUN 2016 10:58", "Gnomes R Us", PurchaseOrderStatus.Ordered, "Not Delivered"),
                      PurchaseOrder(2, "10 JUN 2016 10:58", "Gnomes R Us", PurchaseOrderStatus.Ordered, "Not Delivered"),
                      PurchaseOrder(3, "1 JUN 2016 10:58", "Gnomes R Us", PurchaseOrderStatus.Delivered, "6 JUN 2016 16:23"),
                      PurchaseOrder(4, "4 JUN 2016 10:58", "Gnomes R Us", PurchaseOrderStatus.Delivered, "9 JUN 2016 12:26")
    )
  }

  def getWorkers: Array[WorkerList] = {
//    ArrayBuffer(WorkerList("Robert, "1234", "standard", 20.30), Worker("James", "1234", "standard", 30.30), Worker("Tom", "1234", "admin", 10.32))
    Array(WorkerList("Harrison", "1234"), WorkerList("Mark", "1234"), WorkerList("Jackie", "1234"), WorkerList("Zeph", "1234"), WorkerList("Paul", "1234"))

  }

}

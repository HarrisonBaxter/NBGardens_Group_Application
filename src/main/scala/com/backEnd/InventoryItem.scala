package com.backEnd

import scala.collection.mutable.ArrayBuffer
import scalafx.collections.ObservableBuffer

/**
  * Created by MacZ on 17/06/2016.
  */
case class InventoryItem(id : Int, name : String, quantity : Int, porouswareQuantity: Int, location : Double) {

}

object InventoryItem{

   var inventoryItems = ObservableBuffer(InventoryItem(901, "Angry Gnome", 35, 15, 11.20),
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

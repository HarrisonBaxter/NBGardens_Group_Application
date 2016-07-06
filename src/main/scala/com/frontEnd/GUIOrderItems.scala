package com.frontEnd

import scalafx.beans.property.StringProperty


/**
  * Created by Administrator on 30/06/2016.
  */
class GUIOrderItems (id: String, item: String, quantity: String, porousQuantity: String)  {


  val ID = new StringProperty(this, "ID", id)
  val Item = new StringProperty(this, "Item", item)
  val Quantity = new StringProperty(this, "Quantity", quantity)
  val PorousQuantity = new StringProperty(this, "PorousQuantity", porousQuantity)

}

package com.frontEnd

import scalafx.beans.property.StringProperty

/**
  * Created by Administrator on 01/07/2016.
  */
class GUIStock(id: String, name : String,  quantity : String, porouswareQuantity: String, location : String) {


  val ID = new StringProperty(this, "ID", id)
  val Name = new StringProperty(this, "Name", name)
  var Quantity = new StringProperty(this, "Quantity", quantity)
  var PorousQuantity = new StringProperty(this, "PorousQuantity", porouswareQuantity)
  val Location = new StringProperty(this, "Location", location)



}

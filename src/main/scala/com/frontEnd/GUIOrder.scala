package com.frontEnd


import scalafx.beans.property.StringProperty

/**
  * Created by Administrator on 29/06/2016.
  */
class GUIOrder(id: String, status : String) {


  val ID = new StringProperty(this, "ID", id)
  val Status = new StringProperty(this, "status", status)

}
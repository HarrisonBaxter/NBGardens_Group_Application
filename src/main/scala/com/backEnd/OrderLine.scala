package com.backEnd

import scala.collection.mutable.ArrayBuffer
import scalafx.collections.ObservableBuffer


/**
  * Created by markk on 21/06/2016.
  */

case class OrderLine(pid : Int, quantity: Int, porouswareQuantity: Int) {


}

object OrderLine {
  var orderLines = ObservableBuffer {
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

  }
}
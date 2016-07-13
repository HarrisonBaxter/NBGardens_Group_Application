package com.backEnd

import scala.collection.mutable.ArrayBuffer
import scalafx.collections.ObservableBuffer


/**
  * Created by markk on 21/06/2016.
  */

case class OrderLine(pid : Int, quantity: Int, porouswareQuantity: Int) {

}

object OrderLine {

  var orderLines = ArrayBuffer {
    (852, 10, 0)
    (901, 5, 5)
    (902, 1, 1)
    (920, 4, 0)
    (919, 1, 0)
    (918, 1, 0)
    (918, 2, 0)
    (904, 1, 1)
    (916, 2, 0)
    (909, 1, 0)
    (903, 1, 1)
    (911, 1, 0)
    (916, 1, 1)
    (901, 2, 2)
    (909, 5, 0)
    (917, 2, 2)
    (920, 5, 0)
    (914, 1, 1)
    (915, 1, 1)
    (905, 1, 1)
    (908, 2, 0)
    (902, 1, 1)
    (915, 1, 1)
    (909, 1, 0)
    (916, 1, 1)
    (901, 2, 2)
    (910, 2, 0)

  }


}
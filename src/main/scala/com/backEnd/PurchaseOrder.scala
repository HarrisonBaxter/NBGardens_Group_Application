package com.backEnd

import scala.collection.mutable.ArrayBuffer
import com.backEnd.PurchaseOrderStatus

/**
  * Created by Administrator on 29/06/2016.
  */
case class PurchaseOrder( dId :Int, dtMade :String, sup :String, var status: PurchaseOrderStatus.Value = PurchaseOrderStatus.Ordered, dtDelivered :String){

}

object PurchaseOrder{

var purchaseOrders = ArrayBuffer(PurchaseOrder(1, "16 JUN 2016 10:58", "Gnomes R Us", _,"Not Delivered"),
PurchaseOrder(2, "10 JUN 2016 10:58", "Gnomes R Us", _, "Not Delivered"),
PurchaseOrder(3, "1 JUN 2016 10:58", "Gnomes R Us", _, "Not Delivered"),
PurchaseOrder(4, "4 JUN 2016 10:58", "Gnomes R Us", _, "Not Delivered"))
}


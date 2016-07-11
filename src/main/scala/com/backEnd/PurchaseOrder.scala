package com.backEnd

import scala.collection.mutable.ArrayBuffer
import com.backEnd.PurchaseOrderStatus

/**
  * Created by Administrator on 29/06/2016.
  */
case class PurchaseOrder( dId :Int, dtMade :String, sup :String, var status: PurchaseOrderStatus.Value = PurchaseOrderStatus.Ordered, dtDelivered :String){

}

object PurchaseOrder{

var purchaseOrders = DataDump.getPurchaseOrders
}


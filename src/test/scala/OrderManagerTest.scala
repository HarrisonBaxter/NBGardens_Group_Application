import com.backEnd.{Order, OrderList}
import com.reference.{Inventory, OrderManager, OrderStatus}
import org.scalatest.{FlatSpec, FunSuite, Inside, Matchers}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Paul on 03/07/2016.
  */
class OrderManagerTest extends FunSuite with Inside with Matchers{

  var oListTest = new OrderList()

  var inventoryTest = new Inventory()

  val orderManager = new OrderManager

  //orderManager.createOrder()



  test("Create com.backEnd.Order"){
    orderManager.createOrder()
    oListTest.printList(inventoryTest)
    assert(Order(15,OrderStatus.Ordered,ArrayBuffer()) ==oListTest.list(14))
  }


  test("Ship Item"){
    orderManager.shipItem(1)

    assert((oListTest.list(1).status == OrderStatus.Shipped) == true)
  }

  test("Update com.backEnd.Order List"){
    orderManager.updateOrderList()
  }


}

import com.backEnd.{Order, OrderLine, OrderList}
import com.reference.{Inventory, OrderStatus}
import org.scalatest.{FlatSpec, FunSuite, Inside, Matchers}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Paul on 01/07/2016.
  */
class OrderListTest extends FunSuite with Inside with Matchers{

  var oListTest = new OrderList()

  var inventoryTest = new Inventory()

  var orderLineTest = new ArrayBuffer[OrderLine]

  var orderTest = new Order(30,OrderStatus.Allocated, orderLineTest)


  test("Add com.backEnd.Order"){
    //println("Testing Add com.backEnd.Order Function")
      oListTest.addOrder(30, OrderStatus.Allocated, orderLineTest)
      assert((oListTest.findOrder(30).get == orderTest))


  }



  test("com.backEnd.Order Shipped"){
    oListTest.addOrder(31, OrderStatus.Ordered, orderLineTest)
    oListTest.markedShipped(15)
    assert((oListTest.findOrder(31).get.status == OrderStatus.Shipped)==true)

  }



  test("com.backEnd.Order Allocation"){
    oListTest.addOrder(32, OrderStatus.Ordered, orderLineTest)
    oListTest.orderAllocation(16)
    assert((oListTest.findOrder(32).get.status == OrderStatus.Allocated)==true)

  }


  test("com.backEnd.Order Delievered"){
    oListTest.addOrder(33, OrderStatus.Ordered, orderLineTest)
    oListTest.markedDelivered(17)
    assert((oListTest.findOrder(33).get.status == OrderStatus.Delivered)==true)

  }


  test("com.backEnd.Order Ordered"){
    oListTest.addOrder(34, OrderStatus.Ordered, orderLineTest)
    oListTest.markOrdered(18)

  }




  test("Remove com.backEnd.Order"){


  }


}

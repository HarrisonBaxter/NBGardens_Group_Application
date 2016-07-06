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

  //print item


  test("Display Single Item"){
    val printItemTest = oListTest.printListIndividual(0,inventoryTest)
    val expected:String = "ID : " + oListTest.list(0).id + " | Item: " + inventoryTest.findProduct(oListTest.list(0).id).get.name + " | Status : " + oListTest.list(0).status
    println(expected)
    //assert(printItemTest.equals(expected))
  }

  //Testing Add Method
  test("Add com.backEnd.Order"){
    //println("Testing Add com.backEnd.Order Function")
      oListTest.addOrder(30, OrderStatus.Allocated, orderLineTest)
      assert((oListTest.list.last == orderTest)==true)
    //oListTest.printList(itemTest)
    //println("Complete Add Function Test")

  }


  //Test com.backEnd.Order Allocation
  test("com.backEnd.Order Shipped"){
    oListTest.addOrder(31, OrderStatus.Ordered, orderLineTest)
    oListTest.markedShipped(15)
    assert((oListTest.list.last.status == OrderStatus.Shipped)==true)
    //oListTest.printList(inventoryTest)
  }


  //Test com.backEnd.Order Allocation
  test("com.backEnd.Order Allocation"){
    oListTest.addOrder(32, OrderStatus.Ordered, orderLineTest)
    oListTest.orderAllocation(16)
    assert((oListTest.list.last.status == OrderStatus.Allocated)==true)
    //oListTest.printList(inventoryTest)
  }

  //Test com.backEnd.Order Allocation
  test("com.backEnd.Order Delievered"){
    oListTest.addOrder(33, OrderStatus.Ordered, orderLineTest)
    oListTest.markedDelivered(17)
    assert((oListTest.list.last.status == OrderStatus.Delivered)==true)
    //oListTest.printList(inventoryTest)
  }

  //Test com.backEnd.Order Allocation
  test("com.backEnd.Order Ordered"){
    oListTest.addOrder(34, OrderStatus.Ordered, orderLineTest)
    oListTest.markOrdered(18)
    assert((oListTest.list.last.status == OrderStatus.Ordered)==true)
    //oListTest.printList(inventoryTest)
  }



  //Test com.backEnd.Order Allocation
  test("Remove com.backEnd.Order"){

  }


}

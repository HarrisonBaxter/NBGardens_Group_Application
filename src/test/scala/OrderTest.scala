import com.backEnd.{Order, OrderLine}
import com.reference.OrderStatus
import org.scalatest.{FlatSpec, Inside, Matchers}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Paul on 03/07/2016.
  */
class OrderTest extends FlatSpec with Inside with Matchers{

  val orderLineExample = new OrderLine(910,10,1)
  val orderLineExample2 = new OrderLine(910,2,3)

  val orderExample = new Order(1,OrderStatus.Allocated, ArrayBuffer(orderLineExample,orderLineExample2))

  inside(orderExample) {case Order(id, status, orderitems) =>
      id should be (1)
      status should be (OrderStatus.Allocated)
      orderitems should be(ArrayBuffer(orderLineExample,orderLineExample2))
  }


}

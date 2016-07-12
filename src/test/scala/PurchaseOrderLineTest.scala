import com.backEnd.PurchaseOrderLineItem
import org.scalatest._

/**
  * Created by Paul on 01/07/2016.
  */
class PurchaseOrderLineTest extends FlatSpec with Inside with Matchers{

  val purchaseExample = new PurchaseOrderLineItem(4,901,4)

  "An Purchase Order" should "have these details" in{
    purchaseExample.poId should equal(4)
    purchaseExample.pid should equal(901)
    purchaseExample.quantity should equal(4)
    info("Purchase Order Fields Correct")
  }

}

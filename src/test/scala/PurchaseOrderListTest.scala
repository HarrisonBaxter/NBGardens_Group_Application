import com.backEnd.{PurchaseOrder, PurchaseOrderList, PurchaseOrderStatus}
import org.scalatest._

/**
  * Created by Paul on 11/07/2016.
  */
class PurchaseOrderListTest extends FlatSpec with Matchers{

  val purchaseOrderListTest = new PurchaseOrderList()

  val purchaseOrderTest = new PurchaseOrder(10,"12 July 2016 12:30", "Gnomes R Us",PurchaseOrderStatus.Processed, "Not Delivered")

  it should "Purchase Order Success" taggedAs PurchaseSuccess in{
    purchaseOrderListTest.addNewStockPurchase(purchaseOrderTest)
    purchaseOrderListTest.findPoById(10).isEmpty shouldEqual false
  }

  it should "Purchase Order Fail" taggedAs PurchaseFail in{
    purchaseOrderListTest.addNewStockPurchase(purchaseOrderTest)
    purchaseOrderListTest.findPoById(11).isEmpty shouldEqual true
  }

}

object PurchaseSuccess extends Tag("com.test.PurchaseSuccess")
object PurchaseFail extends Tag("com.test.PurchaseFail")
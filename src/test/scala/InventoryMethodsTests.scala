import com.reference.{Inventory, main1}
import org.scalatest.FunSuite

/**
  * Created by Administrator on 06/07/2016.
  */
class InventoryMethodsTests extends FunSuite {

  //set up tests

  //set up the objects
  var inventory:Inventory = new Inventory()
  var purchaseOrders = main1.purchaseOrders.purchaseOrders.toList
  var stockPurchaseItems = main1.purchaseOrders.stockPurchaseItems.toList


  test("Incrementing the stock levels when a stock delivery is made") {
    //set up the variables
    var itemId = 901 //which has a starting quantity of 35
    var currentQuantity = inventory.findProduct(itemId).get.quantity
    var increase = 5 //lets add 5 more

    //call method
    inventory.incrementStock(itemId, increase)

    //show result
    var newItem = inventory.findProduct(itemId).get
    var updatedQuantity = newItem.quantity

    assert((currentQuantity + increase) == updatedQuantity)
  }



  test("Decrementing the stock levels when packing a customer order") {
    //set up the variables
    var itemId = 902 //which has a starting quantity of 35
    var currentQuantity = inventory.findProduct(itemId).get.quantity
    var decrease = 5 //lets remove 5
    var porousDecrease = 1 //one item we are removing has porousware on

    //call method
    inventory.decrementStock(itemId, decrease, porousDecrease)

    //show result
    var newItem = inventory.findProduct(itemId).get
    var updatedQuantity = newItem.quantity

    assert((currentQuantity - decrease) == updatedQuantity)
  }


  test ("This is another test"){

  }

}

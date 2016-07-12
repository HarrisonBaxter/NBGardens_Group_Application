import com.backEnd.InventoryItem
import org.scalatest.{FlatSpec, Inside, Matchers}

/**
  * Created by Paul on 01/07/2016.
  */
class InventoryItemTest extends FlatSpec with Inside with Matchers{

  val itemExample = new InventoryItem(1, "Gnome", 1, 1,1.1)

  info("Starting")
  "An Item" should "have these details" in{
    itemExample.id should equal(1)
    itemExample.name should equal("Gnome")
    itemExample.quantity should equal(1)
    itemExample.porouswareQuantity should equal(1)
    itemExample.location should equal(1.1)
    info("Item Fields are Correct")
  }

  it should "throw NoSuchElementException" in{
    evaluating()
      assert(itemExample.id == 2)
  }

  inside(itemExample){ case InventoryItem(id, name, quantity, porouswareQuantity, location) =>
      id should be (1)
      name should be ("Gnome")
      quantity should be (1)
      porouswareQuantity should be (1)
      location should be (1.1)
  }
  println("Item Expected Succeed Complete")

  inside(itemExample){ case InventoryItem(id, name, quantity, porouswareQuantity, location) =>
    id should not be (0)
    name should not be ("")
    quantity should not be (0)
    porouswareQuantity should not be (0)
    location should not be (0.0)
  }
  println("Item Expected Fail Completed")



}

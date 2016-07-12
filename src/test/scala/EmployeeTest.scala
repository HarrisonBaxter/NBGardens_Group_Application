import com.backEnd.WorkerList
import org.scalatest.{FlatSpec, Matchers, Tag}

/**
  * Created by Harrison Baxter on 06/07/2016.
  */
class EmployeeTest extends FlatSpec with Matchers {

  it should "Find user" taggedAs FindWorker in {
    WorkerList.findWorker("Harrison").isEmpty shouldEqual false
  }

  it should "Worker Should not Exist" taggedAs NonexistentWorker in{
    WorkerList.findWorker("Taylor").isEmpty shouldEqual true
  }
}

object FindWorker extends Tag("com.test.FindWorker")

object NonexistentWorker extends Tag("com.test.NonexistentWorker")
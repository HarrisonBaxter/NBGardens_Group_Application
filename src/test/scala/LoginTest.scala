import com.reference.main1
import org.scalatest._

/**
  * Created by Paul on 30/06/2016.
  */
class LoginTest extends FlatSpec with Matchers{



  "Main1" should "allow Robert to login" in{
    main1.checkWorker("Robert", "1234")
    var valid = main1.valid
    assert (valid === true)

  }

}

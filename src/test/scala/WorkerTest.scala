import com.reference.Worker
import org.scalatest.{FlatSpec, Inside, Matchers}

/**
  * Created by Paul on 03/07/2016.
  */
class WorkerTest extends FlatSpec with Inside with Matchers{

  val w1 = Worker("Robert","1234","standard", 20.30)

  inside(w1){case Worker(username,password,accounttype,location) =>
      username should be ("Robert")
      password should be ("1234")
      accounttype should be ("standard")
      location should be (20.30)
  }


}

import controllers.{SignUp}

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import models.{User, UserServiceApi, UserService}
import org.specs2.mock.Mockito
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.Await
import scala.concurrent.duration._
import org.mockito.Mockito._
import scala.concurrent.ExecutionContext.Implicits.global

class ChangePasswordSpec extends Specification with Mockito {

  "get new Password" in new WithApplication() {

    val service=mock[UserServiceApi]
    val controller=new SignUp(service)

    when(service.getUser).thenReturn(ListBuffer(User("Nil","Nil")))   //Stubbing

    val logRoute=route(FakeRequest(POST,"/putPass")).get
    status(logRoute) must equalTo(SEE_OTHER)

  }

  "Empty change password form rendering" in new WithApplication() {

    val logRoute=route(FakeRequest(GET,"/getPass")).get
    status(logRoute) must equalTo(OK)
  }

}

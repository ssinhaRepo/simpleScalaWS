import akka.actor.Actor
import spray.routing.HttpService

class SampleServiceActor extends Actor with SampleRoute {
  def actorRefFactory = context
  def receive = runRoute(route)
}

trait SampleRoute extends HttpService {
  import spray.httpx.SprayJsonSupport._
  import Stuff._
  import spray.http.MediaTypes

  val route = {
    path("stuff") {
      respondWithMediaType(MediaTypes.`application/json`) {
        get {
          complete(Stuff(1, "my stuff"))
        } ~
          post {
              entity(as[Stuff]) { stuff =>
              complete(Stuff(stuff.id + 100, stuff.data + " posted"))
            }
          }
      }
    } ~
      get {
        complete("I exist!")
      }
  }

}
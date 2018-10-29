case class Event(name: String)

trait EventListener {
  def listen(event: Event): String
}

class MyListener extends EventListener {
  def listen(event: Event): String = {
    event match {
      case Event("Moose Stampede") ⇒
        "An unfortunate moose stampede occurred"
      case _ ⇒ "Nothing of importance occurred"
    }
  }
}


object TraitTest extends App{
  val myListener = new MyListener
  println(myListener.isInstanceOf[MyListener])
  println(myListener.isInstanceOf[EventListener])
  println(myListener.isInstanceOf[Any])
  println(myListener.isInstanceOf[AnyRef])


}

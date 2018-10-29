object PatternMatching extends App {

    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many" // case _ will trigger if all other cases fail.
    }
    println(matchTest(3)) // prints "many"

  // match the input value of any expression

  println(goldilocks(("porridge", "Papa"))) //what?

  val foodItem = "porridge"

  def goldilocks(expr: Any) = expr match {
    case (`foodItem`, _) ⇒ "eating"
    case ("chair", "Mama") ⇒ "sitting"
    case ("bed", "Baby") ⇒ "sleeping"
    case _ ⇒ "what?"
  }
  println(goldilocks(("porridge", "Papa"))) // eating

  // match a list's different part
  val secondElement = List(1, 2, 3) match {
    case x :: xs ⇒ xs.head
    case _ ⇒ 0
  }

  println(secondElement)
  val secondElement2 = List(1, 2, 3) match {
    case x :: y :: xs ⇒ xs //matches a list which has two or more element
    case _ ⇒ 0
  }

  println(secondElement2)  // List(3) rest of list is a List(rest ..)



}

object CaseClassTest extends App {
  abstract class Term
  case class Var(name: String) extends Term
  case class Fun(arg: String, body: Term) extends Term
  case class App(f: Term, v: Term) extends Term

  var x = Var("x")
  println(x.name)
  println("x hashcode is %d ".format(x.hashCode()))
  var y = Var("x")

  println(y.hashCode())
  println(x==y) // same content
  println(x.equals(y))
  println(x eq(y)) // different object

  def printTerm(term: Term) {
    term match {
      case Var(n) =>
        print(n)
      case Fun(x, b) =>
        print("^" + x + ".")
        printTerm(b)
      case App(f, v) =>
        print("(")
        printTerm(f)
        print(" ")
        printTerm(v)
        print(")")
    }
  }
  def isIdentityFun(term: Term): Boolean = term match {
    case Fun(x, Var(y)) if x == y => true
    case _ => false
  }
  val id = Fun("x", Var("x"))
  val t = Fun("x", Fun("y", App(Var("x"), Var("y"))))
  printTerm(t)
  println
  println(isIdentityFun(id))
  println(isIdentityFun(t))

  case class Dog(var name: String, breed: String)
  val d1 = Dog("Scooby", "Doberman")
  println(d1.toString)
  println(d1.name)
  println(d1.breed)
  d1.name = "wangcai"
  println(d1.name)
  val d2 = d1.copy(name = "Scooby Doo")
  // copy the case class and override some field of it
  println(d2.name)
  println(d2.breed)


  case class Person(first: String, last: String, age: Int = 0, ssn: String = "")
  val p3 = Person(last = "Jones", first = "Fred", ssn = "111-22-3333") // note the order can change, and missing age

 // case class initialize can miss some field. and can set defaut value
  //case class can has unordered initialize list of para


  //Case classes are Serializable:



}

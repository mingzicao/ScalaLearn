object PartiallyAppliedFunctionTest extends App{
  def sum(a: Int, b: Int, c: Int) = a + b + c
  val sum3 = sum _
  println(sum3(1, 9, 7) )
  println(sum(4, 5, 6) )
  def multiply(x: Int, y: Int) = x * y

  val multiplyCurried = (multiply _).curried
  multiplyCurried(3)(2)


  def customFilter(f: Int ⇒ Boolean)(xs: List[Int]) =
    xs filter f
  def onlyEven(x: Int) = x % 2 == 0
  val xs = List(12, 11, 5, 20, 3, 13, 2)
  println(customFilter(onlyEven)(xs))

}

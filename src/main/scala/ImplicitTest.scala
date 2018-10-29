import java.math.BigInteger

abstract class SemiGroup[A] {
  def add(x: A, y: A): A
}
abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A
}
object ImplicitTest extends App {
  implicit object StringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  implicit object IntMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))
  println(sum(List(1, 2, 3)))
  println(sum(List("a", "b", "c")))

/******     Adding method to the existing class without changing the original defination*****/
  class KoanIntWrapper(val original: Int) {
    def isOdd = original % 2 != 0
  }

  implicit def thisMethodNameIsIrrelevant(value: Int) =
    new KoanIntWrapper(value)


/**** first implicit wrap the exisiting class into the implicit class
   and then put then will call the method which is in the wrapper class
  Decorator patter ？？

  ****/
  println(20.isOdd)



  implicit def Int2BigIntegerConvert(value: Int): BigInteger =
    new BigInteger(value.toString)

  def add(a: BigInteger, b: BigInteger) = a.add(b)

  var a = new BigInteger("2")
  var b = new BigInteger("4")
  var c = add(a, b)
  println(c)
  c = a.add(b)
  println(c)


  /***Implicits can be used to automatically convert a value's type to another***/
  add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9)


 /** Implicit Function Parameters can contain a list of implicits:?**/
  def howMuchCanIMake_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
    (amount * hours).toString() + " " + currencyName

  implicit val hourlyRate = BigDecimal(34)
  implicit val currencyName = "Dollars"
  println(howMuchCanIMake_?(30))

/*** what 's the diff btw pass implicit function para list w/ pass normal function as para to another fun ??? */
  def calIncome (rate: Int => Int, hours : Int): Unit = {
    println(rate(hours))
  }
  def rate(x: Int) = x * 5

  val Income = calIncome (rate, 1000)

  def calIncome2 (rate: Int => Int)( hours : Int): Unit = {
    println(rate(hours))
  }
  val Income2 = calIncome (rate, 100)

  def howMuchCanIMake_??(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
    (amount * hours).toString() + " " + currencyName

  println(howMuchCanIMake_??(30))

  println(howMuchCanIMake_??(30, 95))
}
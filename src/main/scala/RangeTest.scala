object RangeTest extends App{
  val someNumbers = Range(0, 10)
  val otherRange = 0 until 10

  println(someNumbers == otherRange) // true
  println(someNumbers.size)
  println(someNumbers.start)
  println(someNumbers.end) // 10
  println(someNumbers.last) // 9
  someNumbers.foreach(x => print(x + " "))

  println(someNumbers(1))

  val someNumbers1 = Range(0, 34).inclusive
  val otherRange1 = 0 to 34

  println(someNumbers1 == otherRange1)




}

import org.scalatest._

import scala.collection.JavaConverters._
object MapTest extends App {
  val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")

  val mapValues = myMap.values
  println(mapValues.size)

  println(mapValues.head)

  val lastElement = mapValues.last
  println(lastElement)

  val myMap1 =
    Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")


  val aNewMap = myMap1 -- List("MI", "OH")

  println("teating  Map -- List")
  println(myMap1)
  println(aNewMap)

  aNewMap.contains("MI")
  myMap.contains("MI")


  val myMap2 =
    Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
  val aNewMap2 = myMap2 - ("MI", "WI") // Notice: single '-' operator for tuples
  println("teating  Map - tuple")
  println(myMap2)
  println(aNewMap2)

}

object SetTest extends App {

  val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
  val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
  val mySet3 = Set("Wisconsin", "Michigan")


  val aNewSet = mySet1 intersect mySet2
  println(aNewSet)
  val afterUnion = mySet1 union mySet2
  println(afterUnion)
  val subSet1 = mySet2 subsetOf mySet1
  println(subSet1)
  val subSet2 = mySet3 subsetOf mySet1
  println(subSet2)


}

object FormattingTest extends App{
  val s = "Hello World"
  println("Application %s".format(s)) // String can be placed in format:

  val c = 'a' //unicode for a
  val d = '\141' //octal for a
  val e = '\"'
  val f = '\\'

  println("%c".format(c))
  println("%c".format(d))
  println("%c".format(e))
  println("%c".format(f))

}

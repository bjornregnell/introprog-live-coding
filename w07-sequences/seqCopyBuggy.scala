object seqCopyBuggy {

  def arrayCopy(xs: Array[Int]) =
    val result = new Array[Int](xs.length)
    var i = 1
    while i < xs.length do
      result(i) = xs(i)

  def test =
    val xs = Array(1,2,3,4,42)
    val ys = arrayCopy(xs)
    //if xs.sameElements(ys) then "OK!" else "ERROR!"

  def main(args: Array[String]): Unit = println(test)
}
def bogoSort(xs: Vector[Int]) = 
  var result = xs
  while result != result.sorted do
    result = util.Random.shuffle(result)
  result
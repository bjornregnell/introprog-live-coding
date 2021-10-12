object Timer:
  def millis[T](action: => T): (Long,T) =
    val t0 = System.currentTimeMillis
    val result = action
    (System.currentTimeMillis - t0, result)

  def nanos[T](action: => T): (Long,T) =
    val t0 = System.nanoTime
    val result = action
    (System.nanoTime - t0, result)
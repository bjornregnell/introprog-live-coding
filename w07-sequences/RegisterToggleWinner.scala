object RegisterToggleWinner:
  val chars: Vector[Char] = 
    ('A' to 'Z').toVector.diff(Seq('Q','Z','X')) ++ Seq('Å','Ä','Ö') 
  
  def takeRandom(n: Int): String = util.Random.shuffle(chars).mkString.take(n)

  val reg = Array.fill(n = chars.length)(elem = 0)
  
  def winner = "ALLA SITT UTOM VINNARE: " + chars(reg.indexOf(reg.max))
  
  def table: Seq[(Char, Int)] = reg.indices.map(i => chars(i) -> reg(i))

  def report = s"Registreringsrapport:\n${table.mkString("\n")}\n\n$winner"

  def toggle(n: Int = 6, delayMillis: Int = 600): Unit = 
    if n > 0 then 
      val rnd = takeRandom(n)
      println(s"$n: SITT NER om ditt förnamn börjar på: ${rnd.sorted}")
      rnd.foreach(c => reg(chars.indexOf(c)) += 1); Thread.sleep(delayMillis)
      println("ALLA STÅR UPP!");                    Thread.sleep(delayMillis)
      toggle(n - 1)
    else ()

  def apply(): Unit =
    val _ = scala.io.StdIn.readLine("ALLA STÅR UPP!\nTryck ENTER!\n")
    toggle()
    println(report)

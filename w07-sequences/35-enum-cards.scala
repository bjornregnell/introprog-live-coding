enum Color(val consoleColor: String): 
  case Black extends Color(Console.BLUE)
  case Red   extends Color(Console.RED)

enum Suit(val color: Color):
  def show(isConsoleColor: Boolean = true): String = 
    if isConsoleColor then color.consoleColor + toString + Console.RESET
    else toString

  case Spade   extends Suit(Color.Black)
  case Heart   extends Suit(Color.Red)
  case Club    extends Suit(Color.Black) 
  case Diamond extends Suit(Color.Red)

@main def testShowSuit = println(Suit.Club.show(isConsoleColor = false))
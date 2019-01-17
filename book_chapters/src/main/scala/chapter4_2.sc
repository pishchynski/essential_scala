import java.util.Date

//Sealed traits
//We can extend sealed trait in current file only and nowhere else

sealed trait Visitor {
  def id: String

  def createdAt: Date

  def age: Long = new Date().getTime - createdAt.getTime
}

final case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

final case class User(
                       id: String,
                       email: String,
                       createdAt: Date = new Date()
                     ) extends Visitor

def missingCase(v: Visitor) =
  v match {
    case User(_, _, _) => "User is here"
  }

//"Match may not be exhaustive" warning

// To prevent extension of the subtypes of sealed traits
// we are to make them final or sealed

//4.2.2.1

sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

case class Circle(radius: Double) extends Shape {
  override def sides = 1

  override def perimeter = 2 * math.Pi * radius

  override def area = math.Pi * radius * radius
}

sealed trait Rect extends Shape {
  def a: Double

  def b: Double

  def sides = 4

  def perimeter = 2 * (a + b)

  def area = a * b
}

case class Square(side: Double) extends Rect {
  val a = side
  val b = side
}

case class Rectangle(a: Double,
                     b: Double) extends Rect

object Draw {
  def apply(s: Shape): String =
    s match {
      case Circle(r) => s"Circle of radius $r"
      case Square(a) => s"Square with side $a"
      case Rectangle(a, b) => s"Rectangle with a = $a, b = $b"
    }
}

Draw(Circle(2))
Draw(Square(1))

//4.2.2.2


sealed trait Color {
  def r: Short

  def g: Short

  def b: Short

  def isLight: Boolean = (0.2989 * r + 0.5870 * g + 0.114 * b) / 255 >= 0.5

  override def toString: String = if(isLight) "Light" else "Dark"
}


object Red extends Color {
  override def r = 255

  override def g = 0

  override def b = 0

  override def toString: String = "Red"
}

object Green extends Color {
  override def r = 0

  override def g = 255.toByte

  override def b = 0

  override def toString: String = "Green"
}

object Blue extends Color {
  override def r = 0

  override def g = 0

  override def b = 255

  override def toString: String = "Blue"
}

case class CustomColor(r: Short,
                       g: Short,
                       b: Short) extends Color

object Color {
  def apply(r: Int,
            g: Int,
            b: Int): Color = {
    CustomColor(r.toShort, g.toShort, b.toShort)
  }
}

Blue.isLight

val cyan = Color(0, 255, 255)

cyan.isLight

val navyBlue = Color(0, 0, 128)

navyBlue.isLight

sealed trait Shape1 {
  def sides: Int

  def perimeter: Double

  def area: Double

  def color: Color
}

case class Circle1(radius: Double, color: Color) extends Shape1 {
  override def sides = 1

  override def perimeter = 2 * math.Pi * radius

  override def area = math.Pi * radius * radius
}

sealed trait Rect1 extends Shape1 {
  def a: Double

  def b: Double

  def sides = 4

  def perimeter = 2 * (a + b)

  def area = a * b
}

case class Square1(side: Double, color: Color) extends Rect1 {
  val a = side
  val b = side
}

case class Rectangle1(a: Double,
                      b: Double,
                      color: Color) extends Rect1

object Draw1 {
  def apply(s: Shape1): String =
    s match {
      case Circle1(r, color) => s"${color.toString} Circle of radius $r"
      case Square1(a, color) => s"${color.toString} Square with side $a"
      case Rectangle1(a, b, color) => s"${color.toString} Rectangle with a = $a, b = $b"
    }
}

Draw1(Circle1(2, Red))
Draw1(Square1(1, cyan))

//4.2.2.3

sealed trait DivisionResult

final case class Finite(res: Int) extends DivisionResult

case object Infinite extends DivisionResult

object divide {
  def apply(numer: Int, denum: Int): DivisionResult = {
      if (denum == 0) Infinite else Finite(numer / denum)
  }
}

val x = divide(1, 2)

val y = divide(2, 0)
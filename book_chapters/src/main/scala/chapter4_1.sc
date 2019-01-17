//Trait

import java.util.Date

trait Visitor {
  def id: String

  def createdAt: Date

  def age: Long = new Date().getTime - createdAt.getTime
}

case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

case class User(
                 id: String,
                 email: String,
                 createdAt: Date = new Date()
               ) extends Visitor

def older(v1: Visitor, v2: Visitor): Boolean = v1.createdAt.before(v2.createdAt)

older(Anonymous("1"), User("2", "test@example.com"))

val anon = Anonymous("Anon1")

anon.createdAt

anon.age

//4.1.4
//4.1.4.1
trait Feline {
  def color: String

  def sound: String
}

case class Cat(name: String,
               color: String,
               food: String) {
  def sound = "meow"
}

case class Tiger(color: String) {
  def sound = "roar"
}

case class Lion(color: String,
                maneSize: Int) {
  def sound = "roar"
}

val tomCat = Cat("Tom", "Ginger", "Milk")

val leoLion = Lion("Ginger", 2)

tomCat.sound

leoLion.sound

//4.1.4.2
trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

case class Circle(radius: Int) extends Shape {
  override def sides = 1

  override def perimeter = 2 * math.Pi * radius

  override def area = math.Pi * radius * radius
}

case class Rectangle(a: Double,
                     b: Double) extends Shape {
  override def sides = 4

  override def perimeter = 2 * (a + b)

  override def area = a * b
}

case class Square(side: Double) extends Shape {
  override def sides = 4

  override def perimeter: Double = 4 * side

  override def area: Double = side * side
}

val circle = Circle(2)

val square = Square(2)

val rect = Rectangle(2, 3)

circle.area

square.perimeter

rect.area

//4.1.4.3

trait Rect extends Shape {
  def a: Double

  def b: Double

  def sides = 4

  def perimeter = 2 * (a + b)

  def area = a * b
}

case class Square1(side: Double) extends Rect {
  val a = side
  val b = side
}

case class Rectangle1(a: Double,
                      b: Double) extends Rect

val sq1 = Square1(4)

val rect1 = Rectangle1(2, 4)

sq1.perimeter

rect1.area


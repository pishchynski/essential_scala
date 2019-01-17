//2.1

"Hello, World!"

"Hello, World".toUpperCase

//2 / 0

2.min(3)

2 min 3

// 2.1.4
1 + 2

"3".toInt

"foo".toInt

//2.2
//2.2.2
"abcdef".take(3)

"abcdef".take(2)

"hello".toUpperCase.toLowerCase

"Hello World!".take(2 + 3)

//2.2.3

123.toShort

123.toByte

43 - 3 + 2

43.-(3).+(2) // Warning Scala <= 2.10: (43).-(3).+(2)

// a.b(c) -> a b c
// a b c d e <- a.b(c).d(e)

"the quick brown fox" split " "

// precedence rules

2 * 3 + 4 * 5

(2 * 3) + (4 * 5)

2 * (3 + 4) * 5

//2.2.5
//2.2.5.1
"foo".take(1)

"foo" take 1

1 + 2 + 3

1.+(2).+(3)

//2.2.5.2
1 + 2 + 3

6

//2.3
//2.3.1

42

42.0

42.0f

42L

// No literal syntax for Short and Byte
//2.3.2
true

false

//2.3.3

'a'

//2.3.4

"this is a string"

"the\nusual\tescape characters apply"

//2.3.5

null

//Nulls are bad practice -- use Optional

//2.3.6
//Unit is equivalent of Java's void

//2.3.8

"Hello!" // Type: String

println("Hello") // Type: Unit

//2.4
object Test {}

Test

//2.4.1

object Test2 {
  def name: String = "Test object 2"
}

Test2.name

object Test3 {
  def hello(name: String) = "Hello, " + name
}

Test3.hello("World")

//2.4.2

object Test4 {
  val name = "World"
  def hello(other: String) = name + " says hi to " + other
}

Test4.hello("me")

//2.4.3

object Test5 {
  val simpleField = {
    println("Evaluating simpleField")
    42
  }

  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

Test5

Test5.simpleField

Test5.simpleField

Test5.noParameterMethod

Test5.noParameterMethod

object Test6 {
  var simpleField = {
    println("Evaluating simpleField")
    42
  }

  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

Test6

Test6.simpleField

Test6.simpleField

Test6.noParameterMethod

Test6.noParameterMethod

//2.4.5
//2.4.5.1

object Cat1 {
  val name = "Oswald"
  val color = "Black"
  val food = "Milk"
}

object Cat2 {
  val name = "Henderson"
  val color = "Ginger"
  val food = "Chips"
}

object Cat3 {
  val name = "Quentin"
  val color = "Tabby and white"
  val food = "Curry"
}

//2.4.5.2

object calc {
  def square(x: Double) = x * x

  def cube(x: Double) = square(x) * x
}

calc.cube(2)

//2.4.5.3

object calc2 {
  def square(x: Double) = x * x

  def square(x: Int) = x * x

  def cube(x: Double) = square(x) * x

  def cube(x: Int) = square(x) * x
}

calc2.cube(3)

//2.4.5.4

object argh{
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}

argh.c + argh.b + argh.a

//2.4.5.5

object person {
  val firstName = "Human"

  val lastName = "Peoples"
}



object alien {
  def greet(p: person.type) = "Hello, " + p.firstName
}

alien.greet(person)

//2.6

if (1 < 2) "Yes" else "No"

// Conditional is an expression - has type and returns value

if (1 < 2) println("Yes") else println("No")

// Not selected expression is not evaluated!

//2.6.2

{1; 2; 3}

{
  println("Side effect 1")
  println("Side effect 2")
  3
}

def name: String = {
  val title = "Professor"
  val name = "Yankee"
  title + " " + name
}

name

//2.6.4
//2.6.4.1

if(1 > 2) "alien" else "predator"

//2.6.4.2

if(1 > 2) "alien" else 42

if(false) "hello"


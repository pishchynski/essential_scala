//3.1.1
class Person {
  val firstName = "Human"

  val lastName = "Peoples"

  def name = firstName + " " + lastName
}

val person = new Person

person.firstName

person

val newPerson = new Person

val anotherNewPerson = new Person

object alien {
  def greet(p: Person) = "Greetings, " + p.firstName + " " + p.lastName
}

alien.greet(person)

alien.greet(newPerson)

//3.1.2

class Person2(first: String, last: String) {
  val firstName = first
  val lastName = last

  def name = firstName + " " + lastName
}

val dave = new Person2("Dave", "Gahan")

dave.name

class Person3(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
}

new Person3("Martin", "Gore").name

//3.1.3

new Person3(firstName = "Andrew", lastName = "Fletcher")

def greet(firstName: String = "Some", lastName: String = "Body") = "Greetings, " + firstName + " " + lastName + "!"

greet("Busy")

greet(lastName = "Elephant")

//3.1.4
def badness = throw new Exception("error")

def otherbadness = null

val bar = if (true) 123 else badness

val baz = if (false) "worked!" else otherbadness

//3.1.6.1
class Cat(val name: String, val color: String, val food: String) {
}

val oswald = new Cat("Oswald", "Black", "Milk")
val henderson = new Cat("Henderson", "Ginger", "Sausage")
val quentin = new Cat("Quentin", "Gray", "Fish")

//3.1.6.2
object MilkShop {
  def willServe(cat: Cat): Boolean = {
    cat.food == "Milk"
  }
}

MilkShop.willServe(oswald)
MilkShop.willServe(henderson)

//3.1.6.3
class Director(val firstName: String,
               val lastName: String,
               val yearOfBirth: Int) {
  def name = firstName + " " + lastName
}

class Film(val name: String,
           val yearOfRelease: Int,
           val imdbRating: Double,
           val director: Director) {
  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) = director == this.director

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)

val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)

val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)

val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)

eastwood.yearOfBirth

dieHard.director.name

invictus.isDirectedBy(nolan)

granTorino.copy(imdbRating = 8.9)

inception.copy().copy().copy()

//3.1.6.4
class Counter(val initial: Int) {
  def inc = new Counter(initial + 1)

  def dec = new Counter(initial - 1)

  def count = initial
}

new Counter(10).inc.dec.inc.inc.count

//3.1.6.5
class FasterCounter(val initial: Int) {
  def inc(by: Int = 1) = new FasterCounter(initial + by)

  def dec(by: Int = 1) = new FasterCounter(initial - by)

  def count = initial
}

new FasterCounter(10).inc(2).dec(2).inc().inc().count

//3.1.6.6
class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class AdderCounter(val initial: Int) {
  def inc(by: Int = 1) = new AdderCounter(initial + by)

  def dec(by: Int = 1) = new AdderCounter(initial - by)

  def count = initial

  def adjust(adder: Adder) = new AdderCounter(adder.add(initial))
}

new AdderCounter(10).adjust(new Adder(5)).count




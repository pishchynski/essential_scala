//Pattern Matching

case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

object Person {
  def apply(longName: String): Person = {
    val parts = longName.split(" ")
    apply(parts(0), parts(1))
  }
}

object DepecheFan {
  def inspect(person: Person): String =
    person match {
      case Person("Dave", "Gahan") => "I love you, Dave!"
      case Person("Martin", "Gore") => "Maaaartiiiin!"
      case Person("Andy", "Flatcher") => "..."
      case Person(first, last) => s"It's just $first"
    }
}

DepecheFan.inspect(Person("Dave", "Gahan"))

DepecheFan.inspect(Person("Some", "Body"))

//3.5.3
//3.5.3.1
case class Cat(name: String, color: String, food: String) {
}

val oswald = Cat("Oswald", "Black", "Milk")
val henderson = Cat("Henderson", "Ginger", "Sausage")
val quentin = Cat("Quentin", "Gray", "Fish")

object MilkShop {
  def willServe(cat: Cat): Boolean =
  cat match {
    case Cat(_, _, "Milk") => true
    case Cat(_, _, _) => false
  }
}

MilkShop.willServe(oswald)
MilkShop.willServe(quentin)

//3.5.3.2

case class Director(firstName: String,
                    lastName: String,
                    yearOfBirth: Int) {

  def name() = firstName + " " + lastName
}

case class Film(title: String,
                yearOfRelease: Int,
                imdbRating: Double,
                director: Director) {

  def directorsAge() = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = director == this.director
}

object Dad {
  def rate(film: Film): Double =
    film match {
      case Film(_, _, _, Director("Clint", "Eastwood", 1930)) => 10.0
      case Film(_, _, _, Director("John", "McTiernan", 1951)) => 7.0
      case Film(_, _, _, _) => 3.0
    }
}

val eastwood = Director("Clint", "Eastwood", 1930)
val mcTiernan = Director("John", "McTiernan", 1951)
val nolan = Director("Christopher", "Nolan", 1970)

val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)
val memento = Film("Memento", 2000, 8.5, nolan)
val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)

Dad.rate(unforgiven)
Dad.rate(memento)
Dad.rate(dieHard)


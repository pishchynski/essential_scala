//3.4
case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

val dave = Person("Dave", "Gahan")

Person

//3.4.1 Case class features
//field for each constructor argument
dave.lastName

//default toString
dave

//equal and hashCode based on fields
dave.equals(Person("Dave", "Gahan"))

dave == Person("Dave", "Gahan")

//copy method
val daveCopy = dave.copy()

val otherDave = dave.copy(lastName = "Gurnell")

//implements Serializable and Product(!)

dave.productArity

//3.4.2 Case class companion object features

//use apply instead of constructor
Person("Dave", "Gahan") == Person("Martin", "Gore")

Person("Dave", "Gahan") == Person("Dave", "Gahan")

//has unapply method too :)

//3.4.3

case object Citizen {
  def firstName = "John"

  def lastName = "Doe"

  def name = firstName + " " + lastName
}

Citizen.toString

//3.4.5.1

case class Cat(name: String,
               color: String,
               food: String)

//3.4.5.2

case class Director(firstName: String,
                    lastName: String,
                    yearOfBirth: Int) {

  def name() = firstName + " " + lastName
}

object Director {
  def older(director1: Director, director2: Director): Director = if (director1.yearOfBirth < director2.yearOfBirth) director1 else director2
}

case class Film(title: String,
                yearOfRelease: Int,
                imdbRating: Double,
                director: Director) {

  def directorsAge() = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = director == this.director
}

object Film {
  def highestRating(film1: Film, film2: Film) = math.max(film1.imdbRating, film2.imdbRating)

  def oldestDirectorAtTheTime(film1: Film, film2: Film) = {
    if(film1.directorsAge() > film2.directorsAge()) film1.director else film2.director
  }
}

//3.4.5.3
case class Counter(count: Int = 0) {
  def inc(by: Int = 1): Counter = copy(count + by)

  def dec(by: Int = 1): Counter = copy(count - by)
}

//3.4.5.4
case class Person1(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

object Person1 {
  def apply(longName: String): Person1 = {
    val parts = longName.split(" ")
    apply(parts(0), parts(1))
  }
}

new Person1("John", "Doe").name

Person1("John Doe").name

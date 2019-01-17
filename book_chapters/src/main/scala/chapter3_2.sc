//3.2
class Adder(amount: Int) {
  def add(in: Int): Int = in + amount
}

//3.2.1
class FunAdder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

val add3 = new FunAdder(3)

add3.apply(2)

add3(4)

//3.3
class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp = new Timestamp(
    hours * 60 * 60 + minutes * 60 + seconds
  )
}

Timestamp(1, 1, 1).seconds

Timestamp

//3.3.2.1
class Person3(val firstName: String, val lastName: String) {
  def name() = firstName + " " + lastName
}

object Person3 {
  def apply(longName: String): Person3 = {
    val parts = longName.split(" ")
    new Person3(parts(0), parts(1))
  }
}

new Person3("John", "Doe").name()

Person3("John Doe").name()

//3.3.2.2
class Director1(val firstName: String,
                val lastName: String,
                val yearOfBirth: Int) {
  def name() = firstName + " " + lastName
}

object Director1 {
  def apply(firstName: String,
            lastName: String,
            yearOfBirth: Int): Director1 = new Director1(firstName, lastName, yearOfBirth)

  def older(director1: Director1, director2: Director1): Director1 = if (director1.yearOfBirth < director2.yearOfBirth) director1 else director2
}

class Film1(val title: String,
            val yearOfRelease: Int,
            val imdbRating: Double,
            val director: Director1) {
  def directorsAge() = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director1): Boolean = director == this.director
}

object Film1 {
  def apply(title: String,
            yearOfRelease: Int,
            imdbRating: Double,
            director: Director1) = new Film1(title, yearOfRelease, imdbRating, director)

  def highestRating(film1: Film1, film2: Film1) = math.max(film1.imdbRating, film2.imdbRating)

  def oldestDirectorAtTheTime(film1: Film1, film2: Film1) = {
    if(film1.directorsAge() > film2.directorsAge()) film1.director else film2.director
  }
}
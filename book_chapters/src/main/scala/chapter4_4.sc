// Modelling Data with Traits

sealed trait TrafficLight

final case class RedLight() extends TrafficLight
final case class YellowLight() extends TrafficLight
final case class GreenLight() extends TrafficLight


sealed trait CalculationResult

final case class Success(res: Int) extends CalculationResult
final case class Fail(msg: String) extends CalculationResult

sealed trait Source

final case object Well extends Source
final case object Tap extends Source
final case object Spring extends Source

case class Water(size: Int, source: Source, carbonated: Boolean)




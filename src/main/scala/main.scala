// Build a TAX system where different
// products have
// different tax per state and year. (on Scala)
case class TaxRate(state: String, year: Int, rate: Double)

object TaxSystem {
  def calculateTotalPrice(basePrice: Double, state: String, year: Int): Double = {

  }

}
object main extends App{
  //println("Hell222o world!")
  val price = 100.0
  val state = "CA"
  val year = 2024

  println(s"Total price in $state for $year: $" + TaxSystem.calculateTotalPrice(price, state, year))

}

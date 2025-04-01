// Build a TAX system where different products have
// different tax per state and year. (on Scala)
case class TaxRate(state: String, year: Int, rate: Double)

object TaxSystem {
  private var taxRates: List[TaxRate] = List()

  def addTaxRate(state: String, year: Int, rate: Double): Unit = {
    taxRates = TaxRate(state, year, rate) :: taxRates
  }

  def getTaxRate(state: String, year: Int): Option[Double] = {
    taxRates.find(t => t.state == state && t.year == year).map(_.rate)
  }

  def calculateTotalPrice(basePrice: Double, state: String, year: Int): Double = {
    getTaxRate(state, year) match {
      case Some(rate) => basePrice * (1 + rate / 100)
      case None => basePrice // No tax if not found
    }
  }

}
object main extends App{

  TaxSystem.addTaxRate("CA", 2024, 7.25)
  TaxSystem.addTaxRate("NY", 2024, 8.875)
  TaxSystem.addTaxRate("TX", 2024, 6.25)

  //println("Hell222o world!")
  val price = 100.0
  val state = "CA"
  val year = 2024

  println(s"Total price in $state for $year: $$" + TaxSystem.calculateTotalPrice(price, state, year))

}

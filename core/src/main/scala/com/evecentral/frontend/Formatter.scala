package com.evecentral.frontend

private object Thousands {
  def unapply(z: Double) : Option[String] = {
    if (z / 1000.0 >= 1 && z / 900000.0 < 1)
      Some("%.02fk" format (z / 1000.0))
    else None
  }
}

private object Millions {
  def unapply(z: Double) : Option[String] = {
    if (z / 900000.0 >= 1 && z / 900000000.0 < 1)
      Some("%.02fm" format (z / 1000000.0))
    else
      None
  }
}

private object Billions {
  def unapply(z: Double) : Option[String] = {
    if (z / 900000000.0 >= 1)
      Some("%.02fb" format (z / 1000000000.0))
    else
      None
  }
}

object Formatter {
  def price(price: Double) : String = {
    price match {
      case Thousands(n) => n
      case Millions(m) => m
      case Billions(b) => b
      case y => "%.02f" format (y)
    }
  }
}
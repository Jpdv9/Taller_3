package object ManiobrasTrenes {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)

  trait Movimiento
  case class Uno(n: Int) extends Movimiento
  case class Dos(n: Int) extends  Movimiento

  type Maniobra = List[Movimiento]

  def aplicarMovimiento(e:Estado, m: Movimiento): Estado = m match {
    case Uno(n) if (n > 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = principal.splitAt(n)
      (movidos, dos ::: restantes,uno)

    case Uno(n) if (n < 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = uno.splitAt(-n)
      ((movidos.reverse ::: principal.reverse).reverse, restantes, dos)

    case Dos(n) if(n > 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = uno.splitAt(n)
      (restantes,movidos, dos ::: principal)

    case Dos(n) if(n < 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = dos.splitAt(-n)
      (movidos ::: principal, uno, restantes)

    case _ => e
  }
}

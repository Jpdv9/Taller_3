package object ManiobrasTrenes {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)

  trait Movimiento

  case class Uno(n: Int) extends Movimiento
  case class Dos(n: Int) extends Movimiento

  type Maniobra = List[Movimiento]

  def aplicarMovimiento(e: Estado, m: Movimiento): Estado = m match {
    case Uno(n) if (n > 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = principal.reverse.splitAt(n)
      ( restantes.reverse, movidos.reverse ::: uno, dos)

    case Uno(n) if (n < 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = uno.splitAt(-n)
      (principal ::: movidos,  restantes, dos)

    case Dos(n) if (n > 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = principal.splitAt(n)
      (restantes,uno, movidos ::: dos)

    case Dos(n) if (n < 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = dos.splitAt(-n)
      (movidos ::: principal, uno, restantes)

    case _ => e
  }


  def aplicarMovimientos(e: Estado, movs: Maniobra): List[Estado] = {
    def aplicarMovimientosRecurison(estado: Estado, movimiento: Maniobra): List[Estado] = {
      movimiento match {
        case Nil => List(estado)
        case movimiento :: restantes =>
          val nuevoEstado = aplicarMovimiento(estado, movimiento)
          estado :: aplicarMovimientosRecurison(nuevoEstado, restantes)
      }
    }

    aplicarMovimientosRecurison(e, movs)
  }

  def definirManiobra(t1: Tren, t2: Tren): Maniobra = {
    def buscarMovimientos(vagon: Vagon, origen: Tren, destino: Tren): Maniobra = {
      origen.indexOf(vagon) match {
        case -1 => Nil
        case n =>
          val movimientos = Uno(n + 1) :: Uno(destino.indexOf(vagon) + 1) :: Nil
          val nuevoOrigen = origen.patch(n, Nil, 1)
          val nuevoDestino = vagon :: destino
          movimientos ::: buscarMovimientos(vagon, nuevoOrigen, nuevoDestino)
      }
    }


    def definirManiobraRecursion(t1: Tren, t2: Tren, maniobra: Maniobra): Maniobra = {
      t1 match {
        case Nil => maniobra.reverse
        case vagon :: rest =>
          val movimientos = buscarMovimientos(vagon, t1, t2)
          val nuevoT1 = t1.filterNot(_ == vagon)
          definirManiobraRecursion(nuevoT1, t2, maniobra ::: movimientos)
      }
    }

    definirManiobraRecursion(t1, t2, Nil)
  }
}
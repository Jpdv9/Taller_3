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
      val (movidos, restantes) = principal.splitAt(n)
      (movidos, dos ::: restantes, uno)

    case Uno(n) if (n < 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = uno.splitAt(-n)
      ((movidos.reverse ::: principal).reverse, restantes, dos)

    case Dos(n) if (n > 0) =>
      val (principal, uno, dos) = e
      val (movidos, restantes) = uno.splitAt(n)
      (restantes, movidos, dos ::: principal)

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


    def definirManiobraRec(t1: Tren, t2: Tren, maniobra: Maniobra): Maniobra = {
      t1 match {
        case Nil => maniobra.reverse
        case vagon :: rest =>
          val movimientos = buscarMovimientos(vagon, t1, t2)
          val nuevoT1 = t1.filterNot(_ == vagon)
          definirManiobraRec(nuevoT1, t2, maniobra ::: movimientos)
      }
    }

    definirManiobraRec(t1, t2, Nil)
  }
}
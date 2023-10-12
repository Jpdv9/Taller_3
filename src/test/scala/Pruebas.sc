import ManiobrasTrenes._

val e1 = (List('a', 'b', 'c', 'd'), Nil, Nil)
val e2 = aplicarMovimiento(e1, Uno(2))
val e3 = aplicarMovimiento(e2, Dos(2))
val e4 = aplicarMovimiento(e3, Dos(-1))
val e5 = aplicarMovimiento(e4, Uno(-2))

val e = (List('a', 'b'), List('c'), List('d'))
aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))

definirManiobra(List('a', 'b', 'c', 'd'), List('d', 'b', 'c', 'a'))


val e1 = (List(1, 2, 3, 4), Nil, Nil)
val e2 = aplicarMovimiento(e1, Uno(2))
val e3 = aplicarMovimiento(e2, Dos(2))
val e4 = aplicarMovimiento(e3, Dos(-1))
val e5 = aplicarMovimiento(e4, Uno(-2))

val e = (List(1, 2), List(3), List(4))
val resultado = aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))

val maniobraGenerada = definirManiobra(List(1, 2, 3, 4), List(4, 2, 3, 1))

val e1 = (List('X', 'Y', 'Z'), Nil, Nil)
val e2 = aplicarMovimiento(e1, Uno(2))
val e3 = aplicarMovimiento(e2, Dos(1))
val e4 = aplicarMovimiento(e3, Dos(-1))
val e5 = aplicarMovimiento(e4, Uno(-2))

val e = (List('X', 'Y'), List('Z'), Nil)
val resultado = aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))

val maniobraGenerada = definirManiobra(List('X', 'Y', 'Z'), List('Z', 'Y', 'X'))

val e1 = (List(5, 10, 15, 20, 25), Nil, Nil)
val e2 = aplicarMovimiento(e1, Uno(3))
val e3 = aplicarMovimiento(e2, Dos(-1))
val e4 = aplicarMovimiento(e3, Uno(2))
val e5 = aplicarMovimiento(e4, Dos(1))

val e = (List(5, 10, 15, 20, 25), List(25), List(15, 10, 5))
val resultado = aplicarMovimientos(e, List(Dos(3), Uno(2), Uno(-1)))

val maniobraGenerada = definirManiobra(List(5, 10, 15, 20, 25), List(15, 10, 5, 25, 20))

val e1 = (List(10, 20, 30, 40), Nil, Nil)
val e2 = aplicarMovimiento(e1, Dos(3))
val e3 = aplicarMovimiento(e2, Uno(1))
val e4 = aplicarMovimiento(e3, Uno(-2))
val e5 = aplicarMovimiento(e4, Dos(-1))

val e = (List(10, 20, 30), List(40), List(20, 10))
val resultado = aplicarMovimientos(e, List(Uno(3), Dos(2), Uno(-2)))

val maniobraGenerada = definirManiobra(List(10, 20, 30, 40), List(30, 20, 10, 40))

val e1 = (List('X', 'Y', 'Z'), Nil, Nil)
val e2 = aplicarMovimiento(e1, Uno(2))
val e3 = aplicarMovimiento(e2, Dos(1))
val e4 = aplicarMovimiento(e3, Dos(-1))
val e5 = aplicarMovimiento(e4, Uno(-2))

val e = (List('X', 'Y'), List('Z'), Nil)
val resultado = aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))

val maniobraGenerada = definirManiobra(List('X', 'Y', 'Z'), List('Z', 'Y', 'X'))








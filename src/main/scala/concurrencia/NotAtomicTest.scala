package concurrencia

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object NotAtomicTest extends App {
  var contador = 0
  val max = 10000
  for (i <- 1 to max) {
    val f = Future{
      contador = contador + 1
    }
  }
  println(contador)
}

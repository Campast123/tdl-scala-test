package MCampanella.concurrencia

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.concurrent.duration._

//Paradoja de los hermanos
object FutureDilemaDeLosHermanosTest extends App {
  println("Pepe: Vamos a comer? yo cocino")
  println("Juan: Dale, pero esperame que termine de hacer el TP de TDL")
  val f = Future {
    println("Juan agrega diapos al TP")
    Thread.sleep(1000)
    println("Juan termina el TP")
  }
  println("Pepe se queda viendo tele")
  Await.result(f, 1 minutes)
  f.onComplete{
    case Success(n) => println("Pepe empieza a cocinar")
  }
}

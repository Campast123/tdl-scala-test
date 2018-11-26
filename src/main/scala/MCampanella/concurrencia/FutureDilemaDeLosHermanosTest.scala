package MCampanella.concurrencia

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

//Paradoja de los hermanos
object FutureDilemaDeLosHermanosTest extends App {
  println("Pepe: Juan vas a comprar al chino asi me quedo estudiando?")
  println("Juan: Dale, pero vos cocinas.. Ya voy..")
  val f = Future {
    println("Juan va al chino")
    Thread.sleep(1000)
    println("Juan vuelve del chino")
  }
  println("Pepe se queda estudiando")
  Thread.sleep(1000)
  f.onComplete{
    case Success(n) => println("Pepe empieza a cocinar")
  }
}

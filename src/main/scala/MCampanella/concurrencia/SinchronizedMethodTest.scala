package MCampanella.concurrencia
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object SinchronizedMethodTest extends App {

  var contador = 0
  val max = 10000
  for (i <- 1 to max) {
    this.synchronized{
      val f = Future{
        contador += 1
      }
    }
  }
  println(contador)
}

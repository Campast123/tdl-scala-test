package MCampanella.concurrencia

import java.util.concurrent.atomic.AtomicInteger

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object AtomicTest  extends App{
    var contador: AtomicInteger = new AtomicInteger(0)
    val max = 10000
    for (i <- 1 to max) {
      val f = Future{
        contador.getAndIncrement()
      }
    }
    println(contador)
}

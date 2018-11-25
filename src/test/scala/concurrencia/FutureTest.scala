import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.util.{Failure, Success}

object NonBlocking {
  def run = {
    // Definición de la función de acreditar, que precisa de un DNI
    def acreditar(DNI: String) = {
      println(s"Gracias por acreditarse con su DNI: $DNI")
    }

    val nuevaFotoCarnet = Future {
      Thread.sleep(1700)
    }
    nuevaFotoCarnet.onSuccess{ case _ => println("Nueva foto carnet: pura belleza") }

    println("Foto tomada, esperando impresión.")

    val peticionDNI = Future {
      Thread.sleep(2500)
      "123456789A"
    }
    peticionDNI.onSuccess[Unit]{ case _ => println("Nuevo DNI: 123456789A") }

    println("DNI pedido")

    peticionDNI.map(acreditar)

    val gestionesCarnet = Future {
      Thread.sleep(1300)
      println("Formularios de carnet rellenados")
    }

    println("Gestiones de carnet iniciadas.")

    println("1"); Thread.sleep(300)
    println("2"); Thread.sleep(300)
    println("3"); Thread.sleep(300)
    println("4"); Thread.sleep(300)
    println("5"); Thread.sleep(300)
    println("6"); Thread.sleep(300)
    println("7"); Thread.sleep(300)
    println("8"); Thread.sleep(300)
    println("9"); Thread.sleep(300)
    println("10"); Thread.sleep(300)
  }
}
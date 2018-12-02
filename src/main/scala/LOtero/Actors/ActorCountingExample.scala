package LOtero.Actors

import akka.actor.{Actor, ActorSystem, Props}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
case object SumCount

class SumActor extends Actor {
  val system = ActorSystem("SumSystem")
  var count: Int = 0

  def receive = {
    case SumCount => {
         count = count + 1
         println(count)
      }
    case _     => println("huh?")
  }
}


object ActorCountingExample extends App {
  val system = ActorSystem("SumSystem")
  val sumActor = system.actorOf(Props[SumActor], "sumActor")
  var contador = 0
  val max = 10000
  for (i <- 1 to max) {
    val f = Future {
      sumActor ! SumCount
    }
  }
  Thread.sleep(10000)
  println(contador)
}
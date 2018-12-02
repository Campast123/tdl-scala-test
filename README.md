# akka-chat ejemplo integrador
Un ejemplo de un chat simple usando akka y Scala.

## Como ejecutar el chat?
1) Clonar este repo.

2) Entrar a la carpeta por consola del "akka-chat":
```
'user$ cd akka-chat'
```

3) Ejecutar el sbt ( tener SBT previamente instalado ) y ejecutar 'run' y elegir la opcion "org.sandbox.chat.http.HttpChatApp"
```
user$ sbt
[info] ...
sbt:akka-chat$ run
[info] ...
Multiple main classes detected, select one to run:

 [1] org.sandbox.chat.ChatApp
 [2] org.sandbox.chat.cluster.BroadcastManagerCluster
 [3] org.sandbox.chat.cluster.ChatClusterApp
 [4] org.sandbox.chat.cluster.ChatMsgPublisherCluster
 [5] org.sandbox.chat.cluster.ChatServiceCluster
 [6] org.sandbox.chat.cluster.HttpChatServiceCluster
 [7] org.sandbox.chat.cluster.ParticipantAdministratorCluster
 [8] org.sandbox.chat.http.HttpChatApp


Enter number: 8
[info] ...
```

4) Abrir una segunda consola y ejecutar:
```
~$ curl -X GET http://localhost:9000
```
Con esto se va a abrir una sesion en el puerto 9000 y se va a loguear todo el movimiento del chat cuando se desconecte la sesion del paso siguiente.

5) Abrir una tercera consola para hacer los envios de mensajes del chat que va a corresponder al puerto 8080:
```
~$ curl -X GET http://localhost:8080/join/Achim
~$ curl -X POST --data 'one line
another line' http://localhost:8080/contrib/Achim
~$ curl -X GET http://localhost:8080/join/Michael
~$ curl -X PUT --data 'one line again
and yet another line' http://localhost:8080/contrib/Michael
~$ curl -X GET http://localhost:8080/poll/Achim
~$ curl -X GET http://localhost:8080/leave/Michael
~$ curl -X GET http://localhost:8080/shutdown/shutdown
```
Aclaracion:
    El servicio .../join/{Nombre} se usa para incorporar una nueva persona al chat.
    El servicio .../contrib/{Nombre} con el valor "data" con un mensaje, se usa para escribir en el chat.
    El servicio .../poll/{Nombre}
    El servicio .../leave/{Nombre} se usa para que una persona salga del chat.
    El servicio .../shutdown/shutdown se usa para dar por terminada la sala de chat y loguear en el puerto 9000 el resultado.
    
Fuente del akka-chat: https://github.com/fpinscala-muc/akka-chat
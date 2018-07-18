package io.agrim.AddressBook
import io.grpc.{ServerBuilder, ServerServiceDefinition}

class server {

  def runServer(ssd: ServerServiceDefinition): Unit = {
    val server = ServerBuilder.forPort(8888).addService(ssd).build.start
    print("GRPC Server listening on 8888")
    Runtime.getRuntime.addShutdownHook(new Thread(){
      override def run(): Unit = server.shutdown()
    })

    server.awaitTermination()
  }
}

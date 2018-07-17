package io.agrim.AddressBook

import io.agrim.AddressBook.AddressBookService
import person.PersonGrpc
import scala.concurrent.{ ExecutionContext, Future}

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

//  def main(args: Array[String]): Unit = {
//    val ssd = PersonGrpc.bindService(new AddressBookService(), ExecutionContext.global)
//    runServer(ssd)
//  }
}

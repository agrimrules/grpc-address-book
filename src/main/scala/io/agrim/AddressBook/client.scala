package io.agrim.AddressBook

import person.{PersonGrpc, PersonIndex, PersonBody}
import io.grpc.ManagedChannelBuilder

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object client {
  def main(args: Array[String]): Unit = {
    val channel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext(true).build
    val client = PersonGrpc.stub(channel)
    val op = client.add(PersonBody(name = "Bruce",phoneNumber = 123,email = "bruce@wayneenterprise.com"))
//    val op = client.get(PersonIndex(index = 1))
    op.onComplete {
      case Success(value) => println(s"Got the callback, value = $value")
      case Failure(e) => e.printStackTrace()
    }
  }
}

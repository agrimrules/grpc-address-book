package io.agrim.AddressBook
import person.PersonGrpc

import scala.concurrent.ExecutionContext

object Main extends server {
  def main(args: Array[String]): Unit = {
    val ssd = PersonGrpc.bindService(new AddressBookService(), ExecutionContext.global)
    runServer(ssd)
  }
}

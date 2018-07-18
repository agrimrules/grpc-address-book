package io.agrim.AddressBook
import person.{PersonBody, PersonGrpc, PersonIndex}

import scala.concurrent.Future

class AddressBookService extends PersonGrpc.Person {

  override def add(request: PersonBody): Future[PersonIndex] = {
    Future.successful(PersonIndex(index = 1))
  }

  override def remove(request: PersonIndex): Future[PersonBody] = {
    Future.successful(PersonBody(name = "Person", phoneNumber = 12345, email = "username@domain.com"))
  }

  override def update(request: PersonBody): Future[PersonBody] = {
    Future.successful(PersonBody(name= "New Person", phoneNumber = 1234, email = "newemail@domain.com"))
  }

  override def get(request: PersonIndex): Future[PersonBody] = {
    Future.successful(PersonBody(name= "Person", phoneNumber = 54321, email = "user@domain.com"))
  }

}

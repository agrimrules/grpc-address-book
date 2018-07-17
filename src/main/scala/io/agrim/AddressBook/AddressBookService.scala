package io.agrim.AddressBook

import com.datastax.driver.core.Cluster
import com.datastax.driver.mapping.MappingManager
import person.{PersonBody, PersonGrpc, PersonIndex}

import scala.concurrent.Future
import io.grpc.{ServerBuilder, ServerServiceDefinition}


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

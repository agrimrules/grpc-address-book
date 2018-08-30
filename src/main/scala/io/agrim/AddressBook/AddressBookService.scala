package io.agrim.AddressBook
import com.datastax.driver.core.Cluster
import person.{PersonBody, PersonGrpc, PersonIndex}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AddressBookService extends PersonGrpc.Person {
  private val cluster = {
    Cluster.builder().addContactPoint("").build()
  }
  private val session = cluster.connect()
  val personDao = PersonDao(session)
  private val creation = personDao.createTable
  println("Created Table")
  override def add(request: PersonBody): Future[PersonIndex] = {
    val id = personDao.insert(request.name,request.phoneNumber,request.email).get().one().getInt("id")
    Future.successful(PersonIndex(index = id))
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

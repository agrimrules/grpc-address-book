package io.agrim.AddressBook
import com.datastax.driver.core._
import com.datastax.driver.core.querybuilder.{QueryBuilder => qb}
import scala.concurrent._

//case class PersonDao(index: Int, name: String, phoneNumber: Int, email: String)

case class PersonDao(session: Session)(implicit ec: ExecutionContext) {
  private val table = "persons"
  private val index = "id"
  private val name = "name"
  private val phoneNumber = "phoneNumber"
  private val email = "email"

  def createTable: ResultSetFuture = {
    val q = s"create table if not exist $table ($index int primary key, $name text, $phoneNumber int, $email text)"
    session.executeAsync(q)
  }

  def insert(n: String, p: Int, e: String): ResultSetFuture ={
    val q = {
      qb.insertInto(table).value(name,n).value(phoneNumber,p).value(email, e)
    }
    session.executeAsync(q)
  }

}

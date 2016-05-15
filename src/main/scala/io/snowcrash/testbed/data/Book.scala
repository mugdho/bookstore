package io.snowcrash.testbed.data

import slick.driver.PostgresDriver.api._

import scala.util.Random
import javax.inject.Singleton

import io.snowcrash.testbed.DB
import scala.concurrent.Future


case class Book(id: Int = new Random().nextInt(), name: String, author: String)

class BookTable(tag: Tag) extends Table[Book](tag, "book") {
    def id = column[Int]("id", O.PrimaryKey)
    def name = column[String]("name")
    def author = column[String]("author")

    def * = (id, name, author) <> (Book.tupled, Book.unapply)
}

@Singleton
class BookRespository {
    val db = DB.connection

    val books = TableQuery[BookTable]
    def findAll: Future[Seq[Book]] = db.run(books.take(10).result)
}

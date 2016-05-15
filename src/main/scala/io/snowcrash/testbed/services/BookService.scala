package io.snowcrash.testbed.services

import javax.inject.Inject

import com.google.inject.Singleton
import com.twitter.util.Future
import io.snowcrash.testbed.data.{Book, BookRespository}
import io.snowcrash.testbed.common.TwitterConverters._
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class BookService @Inject()(bookRepository: BookRespository) {
    def books(): Future[Seq[Book]] = bookRepository.findAll
}

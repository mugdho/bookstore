package io.snowcrash.testbed.controllers

import javax.inject.Inject

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import io.snowcrash.testbed.services.BookService

class BooksController @Inject()(bookService: BookService) extends Controller{
    get("/books") { request: Request =>
        bookService.books()
    }
}

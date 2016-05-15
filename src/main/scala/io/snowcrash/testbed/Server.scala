package io.snowcrash.testbed

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.logging.filter.{LoggingMDCFilter, TraceIdMDCFilter}
import io.snowcrash.testbed.controllers.BooksController

object ServerMain extends Server

class Server extends HttpServer {
    override protected def defaultFinatraHttpPort: String = ":8080"

    override protected def defaultTracingEnabled: Boolean = false

    override protected def defaultHttpServerName: String = "StackServer"

    override protected def configureHttp(router: HttpRouter): Unit = {
        router
            .filter[LoggingMDCFilter[Request, Response]]
            .filter[TraceIdMDCFilter[Request, Response]]
            .filter[CommonFilters]
            .add[BooksController]

    }
}
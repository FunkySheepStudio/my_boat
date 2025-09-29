package com.example.my_boat
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.response.*

class Server {
    init {
        println("Starting http server")
        embeddedServer(Netty, port = 8080) {
            routing {
                get("/") {
                    call.respondText("Hello, world!")
                }
            }
        }.start(wait = false)
    }
}
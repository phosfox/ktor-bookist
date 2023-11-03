package com.phosfox.plugins

import com.phosfox.UserSession
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.jte.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    install(Resources)
    routing {
        get<Index> {
            call.respond(JteContent("index.kte", mapOf()))
        }
        authenticate("auth-session") {
            get<Home> {
                call.respond("Logged in ${call.principal<UserSession>()?.name}")
            }
            get<Logout> {
                call.sessions.clear<UserSession>()
                call.respondRedirect("/")
            }
        }
        authenticate("auth-form") {
            post("/login") {
                val userName = call.principal<UserIdPrincipal>()?.name.toString()
                call.sessions.set(UserSession(name = userName, count = 1))
                call.respondRedirect("/home")
            }
        }
        //staticResources("/", "static")
    }
}

@Resource("/")
class Index
@Resource("/login")
class Login
@Resource("/logout")
class Logout
@Resource("/home")
class Home

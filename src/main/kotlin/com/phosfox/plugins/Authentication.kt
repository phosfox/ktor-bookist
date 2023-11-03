package com.phosfox.plugins

import com.phosfox.UserSession
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.*

fun Application.configureAuthentication() {
    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 60 * 60
            cookie.extensions["SameSite"] = "lax"
        }
    }
    install(Authentication) {
        form("auth-form") {
            userParamName = "username"
            passwordParamName = "password"
            validate { credentials -> hashedUserTable.authenticate(credentials) }
            challenge {
                call.respond(HttpStatusCode.Unauthorized, "Credentials are not valid")
            }
        }

        session<UserSession>("auth-session") {
            validate { session ->
                if (session.name.startsWith("admin")) {
                    session
                } else {
                    null
                }
            }
            challenge {
                call.respondRedirect("/")
            }
        }

    }

}

val digestFunction = getDigestFunction("SHA-256") { "ktor${it.length}" }
val hashedUserTable = UserHashedTableAuth(
    table = mapOf(
        "admin" to digestFunction("admin")
    ),
    digester = digestFunction
)
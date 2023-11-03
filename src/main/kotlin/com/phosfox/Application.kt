package com.phosfox

import com.phosfox.plugins.configureAuthentication
import com.phosfox.plugins.configureDatabase
import com.phosfox.plugins.configureRouting
import gg.jte.TemplateEngine
import gg.jte.resolve.DirectoryCodeResolver
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.jte.*
import io.ktor.server.netty.*
import java.nio.file.Path

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureAuthentication()
    configureRouting()
    configureDatabase()
    install(Jte) {
        val resolver = DirectoryCodeResolver(Path.of("src/main/kotlin/com/phosfox/views/"))
        templateEngine = TemplateEngine.create(resolver, gg.jte.ContentType.Html)
    }
}

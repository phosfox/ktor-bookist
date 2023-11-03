package com.phosfox.plugins

import com.phosfox.entities.Book
import com.phosfox.entities.book
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.jdbc.JdbcDatabase

fun configureDatabase() {
    // (1) create a database instance
    val database =
        JdbcDatabase(
            url = "jdbc:postgresql://localhost:5432/bookist",
            user = "bookist",
            password = "bookist"
        )

    // (2) start transaction
    database.withTransaction {
        // (3) get an entity metamodel
        val book = Meta.book
        database.runQuery {
            QueryDsl.create(book)
        }
        // (5) insert multiple employees at once
        database.runQuery {
            QueryDsl.insert(book).multiple(
                Book(title = "The Black Swan", isbn = "isbn1"),
                Book(title = "Fooled by Randomness", isbn = "isbn2"),
                Book(title = "Skin in the Game", isbn = "isbn3")
            )
        }

        // (6) select all
        val books = database.runQuery {
            QueryDsl.from(book).orderBy(book.id)
        }

        // (7) print all results
        for (b in books) {
            println(b)
        }
    }
}

package com.example.my_boat
import com.couchbase.lite.*
import android.util.Log

class Database {
    private var db : com.couchbase.lite.Database

    init {
        this.db = this.createDb("db")
        this.createCollection("boats")
        this.listCollections()
    }

    fun createDb(dbName: String): com.couchbase.lite.Database {
        return Database(dbName)
    }

    // Create a new named collection (like a SQL table)
    // in the database's default scope.
    fun createCollection(collName: String) {
        this.db.createCollection(collName)
    }

    fun listCollections()
    {
        this.db.scopes.forEach { scope ->
            Log.w("com.example.my_boat","Scope :: ${scope.name}")
            scope.collections.forEach {
                Log.w("com.example.my_boat","    Collection :: ${it.name}")
            }
        }
    }
}
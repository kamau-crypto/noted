package com.xfactor.noted.database
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(List::class), version=2)
abstract class AppDatabase {
    abstract fun listDao():ListDao
}
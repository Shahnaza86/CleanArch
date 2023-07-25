package com.example.cleanarch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarch.data.models.MusicEntity

@Database(entities = [MusicEntity::class], version = 1, exportSchema = false)
abstract class MusicDataBase : RoomDatabase() {

    abstract fun musicDao(): MusicDao
}
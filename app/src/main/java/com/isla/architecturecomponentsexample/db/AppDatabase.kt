package com.isla.architecturecomponentsexample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.isla.architecturecomponentsexample.db.dao.ReposDao
import com.isla.architecturecomponentsexample.models_db.Repo


@Database(entities = arrayOf(Repo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reposDao(): ReposDao

    companion object {
        const val DATABASE_NAME = "basic-sample-db"
    }

}
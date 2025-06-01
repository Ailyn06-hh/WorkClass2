package com.example.workclass2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workclass2.data.dao.AccountDao
import com.example.workclass2.data.model.AccountEntity

@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun accountDao(): AccountDao
}


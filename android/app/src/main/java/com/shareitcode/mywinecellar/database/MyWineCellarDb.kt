package com.shareitcode.mywinecellar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shareitcode.mywinecellar.dao.VinDao
import com.shareitcode.mywinecellar.entities.Vin

@Database(entities = [Vin::class], exportSchema = false, version = 1)
abstract class MyWineCellarDb : RoomDatabase() {

    abstract fun tousLesVinsDao(): VinDao

    companion object {
        @Volatile
        private var INSTANCE: MyWineCellarDb? = null;

        fun getDatabase(context: Context): MyWineCellarDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyWineCellarDb::class.java,
                    "MyWineCellarDb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
package com.example.nativeapps.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nativeapps.model.Pharmacy


@Database(entities = [Pharmacy::class], version = 1, exportSchema = false)
@TypeConverters(PharmacyFieldsConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pharmacyDao(): PharmacyDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "pharmacies")
                .fallbackToDestructiveMigration()
                .build()
    }

}
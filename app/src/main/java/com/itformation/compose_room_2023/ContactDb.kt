package com.itformation.compose_room_2023
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [(Contact::class)], version = 1, exportSchema = false)
abstract class ContactDb : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        private var instance: ContactDb? = null
        fun getInstance(context: Context): ContactDb {

            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext, ContactDb::class.java, "contact_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }

        }
    }
}
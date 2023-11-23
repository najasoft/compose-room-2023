package com.itformation.compose_room_2023

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Query("select * from Contact")
    fun getContacts(): Flow<List<Contact>>

    @Insert(onConflict = IGNORE)
    suspend fun addContact(contact:Contact): Long

    @Delete
    suspend fun delContat(contact: Contact)

    @Update(onConflict = REPLACE)
    suspend fun updateContact(contact: Contact)

}
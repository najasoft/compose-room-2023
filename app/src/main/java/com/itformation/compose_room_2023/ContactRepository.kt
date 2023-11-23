package com.itformation.compose_room_2023

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class ContactRepository {

    val contactDao:ContactDao = ContactDb.getInstance(ContactApplication.getContext())
        .contactDao()
    fun getContacts(): Flow<List<Contact>> = contactDao.getContacts()
    suspend fun addContact(c: Contact) = CoroutineScope(Dispatchers.IO).launch {
        contactDao.addContact(c)
    }

    suspend fun delContact(c: Contact) = CoroutineScope(Dispatchers.IO).launch {
        contactDao.delContat(c)
    }
    suspend fun updateContact(c: Contact) = CoroutineScope(Dispatchers.IO).launch {
        contactDao.updateContact(c)
    }
}
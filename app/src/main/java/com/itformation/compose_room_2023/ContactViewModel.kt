package com.itformation.compose_room_2023

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContactViewModel: ViewModel(){
    private val rep:ContactRepository = ContactRepository()
    fun getContact(): Flow<List<Contact>> = rep.getContacts()
    fun addContact(c: Contact) = viewModelScope.launch{rep.addContact(c)}
    fun delContact(c: Contact) = viewModelScope.launch{rep.delContact(c)}
    fun updateContact(c: Contact) = viewModelScope.launch{rep.updateContact(c)}
}


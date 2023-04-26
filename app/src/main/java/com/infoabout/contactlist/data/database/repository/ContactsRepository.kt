package com.infoabout.contactlist.data.database.repository

import com.infoabout.contactlist.data.database.dao.ContactsDao
import com.infoabout.contactlist.model.ContactModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactsRepository @Inject constructor(private val dao: ContactsDao) {

    suspend fun insertContact(contact: ContactModel) =
        withContext(Dispatchers.IO) {
            dao.insertContact(contact)
        }

    fun getAllContacts(): Flow<List<ContactModel>> =
        dao.getAllContacts()
            .flowOn(Dispatchers.IO)

    suspend fun deleteContact(contact: ContactModel) =
        withContext(Dispatchers.IO) {
            dao.deleteContact(contact)
        }
}
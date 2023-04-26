package com.infoabout.contactlist.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.infoabout.contactlist.model.ContactModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Query("SELECT * from contacts_table")
    fun getAllContacts() : Flow<List<ContactModel>>

    @Insert
    suspend fun insertContact(contact: ContactModel)

    @Delete
    suspend fun deleteContact(contact: ContactModel)

}
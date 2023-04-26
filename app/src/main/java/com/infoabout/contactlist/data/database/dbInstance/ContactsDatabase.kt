package com.infoabout.contactlist.data.database.dbInstance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infoabout.contactlist.data.database.dao.ContactsDao
import com.infoabout.contactlist.model.ContactModel

@Database(entities = [ContactModel::class], version = 4)
abstract class ContactsDatabase :RoomDatabase(){
    abstract fun contactsDao() : ContactsDao
}
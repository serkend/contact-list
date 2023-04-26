package com.infoabout.contactlist.data.database.dbInstance;

import java.lang.System;

@androidx.room.Database(entities = {com.infoabout.contactlist.model.ContactModel.class}, version = 4)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/infoabout/contactlist/data/database/dbInstance/ContactsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "contactsDao", "Lcom/infoabout/contactlist/data/database/dao/ContactsDao;", "app_debug"})
public abstract class ContactsDatabase extends androidx.room.RoomDatabase {
    
    public ContactsDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.infoabout.contactlist.data.database.dao.ContactsDao contactsDao();
}
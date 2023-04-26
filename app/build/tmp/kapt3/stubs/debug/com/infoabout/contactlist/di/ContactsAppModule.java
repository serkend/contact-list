package com.infoabout.contactlist.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/infoabout/contactlist/di/ContactsAppModule;", "", "()V", "provideDao", "Lcom/infoabout/contactlist/data/database/dao/ContactsDao;", "db", "Lcom/infoabout/contactlist/data/database/dbInstance/ContactsDatabase;", "provideDatabase", "context", "Landroid/app/Application;", "Companion", "app_debug"})
@dagger.Module()
public final class ContactsAppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.infoabout.contactlist.di.ContactsAppModule.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTACTS_DATABASE = "contacts_database";
    
    public ContactsAppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.infoabout.contactlist.data.database.dbInstance.ContactsDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.infoabout.contactlist.data.database.dao.ContactsDao provideDao(@org.jetbrains.annotations.NotNull()
    com.infoabout.contactlist.data.database.dbInstance.ContactsDatabase db) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/infoabout/contactlist/di/ContactsAppModule$Companion;", "", "()V", "CONTACTS_DATABASE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
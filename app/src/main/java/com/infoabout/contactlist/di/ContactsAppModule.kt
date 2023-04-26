package com.infoabout.contactlist.di

import android.app.Application
import androidx.room.Room
import com.infoabout.contactlist.data.database.dbInstance.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ContactsAppModule {

    companion object{
        const val CONTACTS_DATABASE = "contacts_database"
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Application) = Room.databaseBuilder(
        context.applicationContext,
        ContactsDatabase::class.java,
        CONTACTS_DATABASE
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: ContactsDatabase) = db.contactsDao()

}
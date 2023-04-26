package com.infoabout.contactlist.data.database.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/infoabout/contactlist/data/database/repository/ContactsRepository;", "", "dao", "Lcom/infoabout/contactlist/data/database/dao/ContactsDao;", "(Lcom/infoabout/contactlist/data/database/dao/ContactsDao;)V", "deleteContact", "", "contact", "Lcom/infoabout/contactlist/model/ContactModel;", "(Lcom/infoabout/contactlist/model/ContactModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContacts", "Lkotlinx/coroutines/flow/Flow;", "", "insertContact", "app_debug"})
public final class ContactsRepository {
    private final com.infoabout.contactlist.data.database.dao.ContactsDao dao = null;
    
    @javax.inject.Inject()
    public ContactsRepository(@org.jetbrains.annotations.NotNull()
    com.infoabout.contactlist.data.database.dao.ContactsDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertContact(@org.jetbrains.annotations.NotNull()
    com.infoabout.contactlist.model.ContactModel contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.infoabout.contactlist.model.ContactModel>> getAllContacts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull()
    com.infoabout.contactlist.model.ContactModel contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
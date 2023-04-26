package com.infoabout.contactlist.data.database.repository;

import com.infoabout.contactlist.data.database.dao.ContactsDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ContactsRepository_Factory implements Factory<ContactsRepository> {
  private final Provider<ContactsDao> daoProvider;

  public ContactsRepository_Factory(Provider<ContactsDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public ContactsRepository get() {
    return newInstance(daoProvider.get());
  }

  public static ContactsRepository_Factory create(Provider<ContactsDao> daoProvider) {
    return new ContactsRepository_Factory(daoProvider);
  }

  public static ContactsRepository newInstance(ContactsDao dao) {
    return new ContactsRepository(dao);
  }
}

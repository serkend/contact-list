package com.infoabout.contactlist.di;

import com.infoabout.contactlist.data.database.dao.ContactsDao;
import com.infoabout.contactlist.data.database.dbInstance.ContactsDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ContactsAppModule_ProvideDaoFactory implements Factory<ContactsDao> {
  private final ContactsAppModule module;

  private final Provider<ContactsDatabase> dbProvider;

  public ContactsAppModule_ProvideDaoFactory(ContactsAppModule module,
      Provider<ContactsDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public ContactsDao get() {
    return provideDao(module, dbProvider.get());
  }

  public static ContactsAppModule_ProvideDaoFactory create(ContactsAppModule module,
      Provider<ContactsDatabase> dbProvider) {
    return new ContactsAppModule_ProvideDaoFactory(module, dbProvider);
  }

  public static ContactsDao provideDao(ContactsAppModule instance, ContactsDatabase db) {
    return Preconditions.checkNotNullFromProvides(instance.provideDao(db));
  }
}

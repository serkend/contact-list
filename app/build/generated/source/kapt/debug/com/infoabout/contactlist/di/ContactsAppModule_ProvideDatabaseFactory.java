package com.infoabout.contactlist.di;

import android.app.Application;
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
public final class ContactsAppModule_ProvideDatabaseFactory implements Factory<ContactsDatabase> {
  private final ContactsAppModule module;

  private final Provider<Application> contextProvider;

  public ContactsAppModule_ProvideDatabaseFactory(ContactsAppModule module,
      Provider<Application> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public ContactsDatabase get() {
    return provideDatabase(module, contextProvider.get());
  }

  public static ContactsAppModule_ProvideDatabaseFactory create(ContactsAppModule module,
      Provider<Application> contextProvider) {
    return new ContactsAppModule_ProvideDatabaseFactory(module, contextProvider);
  }

  public static ContactsDatabase provideDatabase(ContactsAppModule instance, Application context) {
    return Preconditions.checkNotNullFromProvides(instance.provideDatabase(context));
  }
}

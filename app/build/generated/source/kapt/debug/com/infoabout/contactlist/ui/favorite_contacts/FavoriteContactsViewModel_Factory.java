package com.infoabout.contactlist.ui.favorite_contacts;

import com.infoabout.contactlist.data.database.repository.ContactsRepository;
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
public final class FavoriteContactsViewModel_Factory implements Factory<FavoriteContactsViewModel> {
  private final Provider<ContactsRepository> repositoryProvider;

  public FavoriteContactsViewModel_Factory(Provider<ContactsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FavoriteContactsViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static FavoriteContactsViewModel_Factory create(
      Provider<ContactsRepository> repositoryProvider) {
    return new FavoriteContactsViewModel_Factory(repositoryProvider);
  }

  public static FavoriteContactsViewModel newInstance(ContactsRepository repository) {
    return new FavoriteContactsViewModel(repository);
  }
}

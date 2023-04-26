package com.infoabout.contactlist.ui.new_contact_fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010\u001a\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010\u001b\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\'"}, d2 = {"Lcom/infoabout/contactlist/ui/new_contact_fragment/NewContactFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/infoabout/contactlist/databinding/FragmentNewContactBinding;", "getBinding", "()Lcom/infoabout/contactlist/databinding/FragmentNewContactBinding;", "setBinding", "(Lcom/infoabout/contactlist/databinding/FragmentNewContactBinding;)V", "contentProviderOperations", "Ljava/util/ArrayList;", "Landroid/content/ContentProviderOperation;", "isFavorite", "", "rawContactId", "", "viewModel", "Lcom/infoabout/contactlist/ui/favorite_contacts/FavoriteContactsViewModel;", "getViewModel", "()Lcom/infoabout/contactlist/ui/favorite_contacts/FavoriteContactsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addEmail", "", "cpo", "Lkotlin/collections/ArrayList;", "addFirstName", "addPhoneMobile", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "saveContact", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NewContactFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    public com.infoabout.contactlist.databinding.FragmentNewContactBinding binding;
    private boolean isFavorite = false;
    private final java.util.ArrayList<android.content.ContentProviderOperation> contentProviderOperations = null;
    private final int rawContactId = 0;
    
    public NewContactFragment() {
        super();
    }
    
    private final com.infoabout.contactlist.ui.favorite_contacts.FavoriteContactsViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.infoabout.contactlist.databinding.FragmentNewContactBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.infoabout.contactlist.databinding.FragmentNewContactBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void saveContact() {
    }
    
    private final void addEmail(java.util.ArrayList<android.content.ContentProviderOperation> cpo, int rawContactId) {
    }
    
    private final void addPhoneMobile(java.util.ArrayList<android.content.ContentProviderOperation> cpo, int rawContactId) {
    }
    
    private final void addFirstName(java.util.ArrayList<android.content.ContentProviderOperation> cpo, int rawContactId) {
    }
}
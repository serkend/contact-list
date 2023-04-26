package com.infoabout.contactlist.ui.contacts_fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0003J\u0016\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/infoabout/contactlist/ui/contacts_fragment/ContactsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/infoabout/contactlist/databinding/FragmentContactsBinding;", "getBinding", "()Lcom/infoabout/contactlist/databinding/FragmentContactsBinding;", "setBinding", "(Lcom/infoabout/contactlist/databinding/FragmentContactsBinding;)V", "myContacts", "", "Lcom/infoabout/contactlist/model/ContactModel;", "getMyContacts", "()Ljava/util/List;", "setMyContacts", "(Ljava/util/List;)V", "filter", "", "text", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "readContacts", "setupRV", "contacts", "showRationaleDialog", "title", "message", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ContactsFragment extends androidx.fragment.app.Fragment {
    public com.infoabout.contactlist.databinding.FragmentContactsBinding binding;
    public java.util.List<com.infoabout.contactlist.model.ContactModel> myContacts;
    
    public ContactsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.infoabout.contactlist.databinding.FragmentContactsBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.infoabout.contactlist.databinding.FragmentContactsBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.infoabout.contactlist.model.ContactModel> getMyContacts() {
        return null;
    }
    
    public final void setMyContacts(@org.jetbrains.annotations.NotNull()
    java.util.List<com.infoabout.contactlist.model.ContactModel> p0) {
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
    
    private final void filter(java.lang.String text) {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    private final void readContacts() {
    }
    
    private final void showRationaleDialog(java.lang.String title, java.lang.String message) {
    }
    
    private final void setupRV(java.util.List<com.infoabout.contactlist.model.ContactModel> contacts) {
    }
}
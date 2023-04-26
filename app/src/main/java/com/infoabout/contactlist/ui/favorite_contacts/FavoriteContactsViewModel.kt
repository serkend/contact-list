package com.infoabout.contactlist.ui.favorite_contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infoabout.contactlist.data.database.repository.ContactsRepository
import com.infoabout.contactlist.model.ContactModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteContactsViewModel @Inject constructor(
    private val repository: ContactsRepository
) : ViewModel() {

    private val _contactsFlow: MutableStateFlow<FragmentState> =
        MutableStateFlow(FragmentState.EmptyFragmentState)
    val contactsFlow = _contactsFlow.asSharedFlow()//

    fun getAllContacts() {
        viewModelScope.launch {
            repository.getAllContacts().collect { listContacts ->
                _contactsFlow.value = FragmentState.SuccessFragmentState(listContacts)
            }
        }
    }

    fun deleteContact(contact: ContactModel) {
        viewModelScope.launch {
            repository.deleteContact(contact)
        }
    }

    fun insertContact(contact: ContactModel) {
        viewModelScope.launch {
            repository.insertContact(contact)
        }
    }
}
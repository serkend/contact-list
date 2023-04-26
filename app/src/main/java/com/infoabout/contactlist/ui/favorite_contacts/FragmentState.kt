package com.infoabout.contactlist.ui.favorite_contacts

import com.infoabout.contactlist.model.ContactModel

sealed class FragmentState {
    data class SuccessFragmentState(val data: List<ContactModel>) : FragmentState()
    object EmptyFragmentState : FragmentState()
}

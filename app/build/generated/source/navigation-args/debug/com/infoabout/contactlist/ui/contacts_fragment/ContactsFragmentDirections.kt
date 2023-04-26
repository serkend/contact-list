package com.infoabout.contactlist.ui.contacts_fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.infoabout.contactlist.R
import com.infoabout.contactlist.model.ContactModel
import java.io.Serializable
import kotlin.Int
import kotlin.Suppress

public class ContactsFragmentDirections private constructor() {
  private data class ActionContactsFragmentToUserFragment(
    public val contact: ContactModel? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_contactsFragment_to_userFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(ContactModel::class.java)) {
          result.putParcelable("contact", this.contact as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(ContactModel::class.java)) {
          result.putSerializable("contact", this.contact as Serializable?)
        }
        return result
      }
  }

  public companion object {
    public fun actionContactsFragmentToUserFragment(contact: ContactModel? = null): NavDirections =
        ActionContactsFragmentToUserFragment(contact)

    public fun actionContactsFragmentToNewContactFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_contactsFragment_to_newContactFragment)

    public fun actionContactsFragmentToFavoriteContactsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_contactsFragment_to_favoriteContactsFragment)
  }
}

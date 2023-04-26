package com.infoabout.contactlist.ui.user_fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.infoabout.contactlist.model.ContactModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class UserFragmentArgs(
  public val contact: ContactModel? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(ContactModel::class.java)) {
      result.putParcelable("contact", this.contact as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(ContactModel::class.java)) {
      result.putSerializable("contact", this.contact as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(ContactModel::class.java)) {
      result.set("contact", this.contact as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(ContactModel::class.java)) {
      result.set("contact", this.contact as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): UserFragmentArgs {
      bundle.setClassLoader(UserFragmentArgs::class.java.classLoader)
      val __contact : ContactModel?
      if (bundle.containsKey("contact")) {
        if (Parcelable::class.java.isAssignableFrom(ContactModel::class.java) ||
            Serializable::class.java.isAssignableFrom(ContactModel::class.java)) {
          __contact = bundle.get("contact") as ContactModel?
        } else {
          throw UnsupportedOperationException(ContactModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __contact = null
      }
      return UserFragmentArgs(__contact)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): UserFragmentArgs {
      val __contact : ContactModel?
      if (savedStateHandle.contains("contact")) {
        if (Parcelable::class.java.isAssignableFrom(ContactModel::class.java) ||
            Serializable::class.java.isAssignableFrom(ContactModel::class.java)) {
          __contact = savedStateHandle.get<ContactModel?>("contact")
        } else {
          throw UnsupportedOperationException(ContactModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __contact = null
      }
      return UserFragmentArgs(__contact)
    }
  }
}

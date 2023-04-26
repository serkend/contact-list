package com.infoabout.contactlist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "contacts_table")
data class ContactModel(
    @PrimaryKey val id: Int,
    val userName: String,
    val contactNumber: String,
    val email: String,
    var isFavorite: Boolean = false
) : Parcelable

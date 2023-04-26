package com.infoabout.contactlist.ui.new_contact_fragment

import android.content.ContentProviderOperation
import android.content.ContentUris
import android.content.res.ColorStateList
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.infoabout.contactlist.R
import com.infoabout.contactlist.model.ContactModel
import com.infoabout.contactlist.databinding.FragmentNewContactBinding
import com.infoabout.contactlist.ui.favorite_contacts.FavoriteContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewContactFragment : Fragment() {

    private val viewModel by viewModels<FavoriteContactsViewModel>()

    lateinit var binding: FragmentNewContactBinding
    private var isFavorite = false

    private val contentProviderOperations = ArrayList<ContentProviderOperation>()
    private val rawContactId = contentProviderOperations.size

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddToFavorites.setOnClickListener {
            isFavorite = !isFavorite

            if (isFavorite) {
                binding.btnAddToFavorites.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.blue_star
                    )
                )
            } else {
                binding.btnAddToFavorites.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.gray_star
                    )
                )
            }
        }

        binding.btnCreate.setOnClickListener {

            contentProviderOperations.add(
                ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                    .build()
            )

            addFirstName(contentProviderOperations, rawContactId)
            addPhoneMobile(contentProviderOperations, rawContactId)
            addEmail(contentProviderOperations, rawContactId)
            saveContact()
        }
    }

    private fun saveContact() {
        try {
            val results =
                requireActivity().contentResolver.applyBatch(ContactsContract.AUTHORITY, contentProviderOperations)
            if (isFavorite) {
                val contactId = ContentUris.parseId(results[0].uri!!).toInt()
                val contact = ContactModel(
                    contactId,
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etEmail.text.toString()
                )
                contact.isFavorite = isFavorite
                viewModel.insertContact(contact)
            }
            Snackbar.make(
                binding.root,
                getString(R.string.contact_was_saved),
                Snackbar.LENGTH_SHORT
            ).show()

            findNavController().navigateUp()

        } catch (e: Exception) {
            Snackbar.make(
                binding.root,
                getString(R.string.contact_updating_error),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun addEmail(
        cpo: ArrayList<ContentProviderOperation>,
        rawContactId: Int
    ) {
        cpo.add(
            ContentProviderOperation.newInsert(
                ContactsContract.Data.CONTENT_URI
            ).withValueBackReference(
                ContactsContract.RawContacts.Data.RAW_CONTACT_ID,
                rawContactId
            )
                .withValue(
                    ContactsContract.RawContacts.Data.MIMETYPE,
                    ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE
                )
                .withValue(
                    ContactsContract.CommonDataKinds.Email.DATA,
                    binding.etEmail.text.toString()
                )
                .withValue(
                    ContactsContract.CommonDataKinds.Phone.TYPE,
                    ContactsContract.CommonDataKinds.Email.TYPE_WORK
                )
                .build()
        )
    }

    private fun addPhoneMobile(
        cpo: ArrayList<ContentProviderOperation>,
        rawContactId: Int
    ) {
        cpo.add(
            ContentProviderOperation.newInsert(
                ContactsContract.Data.CONTENT_URI
            ).withValueBackReference(
                ContactsContract.RawContacts.Data.RAW_CONTACT_ID,
                rawContactId
            )
                .withValue(
                    ContactsContract.RawContacts.Data.MIMETYPE,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
                )
                .withValue(
                    ContactsContract.CommonDataKinds.Phone.NUMBER,
                    binding.etPhone.text.toString()
                )
                .withValue(
                    ContactsContract.CommonDataKinds.Phone.TYPE,
                    ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
                )
                .build()
        )
    }

    private fun addFirstName(
        cpo: ArrayList<ContentProviderOperation>,
        rawContactId: Int
    ) {
        cpo.add(
            ContentProviderOperation.newInsert(
                ContactsContract.Data.CONTENT_URI
            ).withValueBackReference(
                ContactsContract.RawContacts.Data.RAW_CONTACT_ID,
                rawContactId
            )
                .withValue(
                    ContactsContract.RawContacts.Data.MIMETYPE,
                    ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
                )
                .withValue(
                    ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,
                    binding.etName.text.toString()
                )
                .build()
        )
    }

}
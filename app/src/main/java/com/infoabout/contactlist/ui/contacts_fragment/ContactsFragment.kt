package com.infoabout.contactlist.ui.contacts_fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.infoabout.contactlist.R
import com.infoabout.contactlist.databinding.FragmentContactsBinding
import com.infoabout.contactlist.model.ContactModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class ContactsFragment : Fragment() {
    lateinit var binding: FragmentContactsBinding
    lateinit var myContacts: List<ContactModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val permissionReadContactsLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                readContacts()
            } else {
                if (!shouldShowRequestPermissionRationale(android.Manifest.permission.READ_CONTACTS)) {
                    showRationaleDialog(
                        getString(R.string.rationale_title), getString(R.string.rationale_desc)
                    )
                }
            }
        }

        permissionReadContactsLauncher.launch(android.Manifest.permission.READ_CONTACTS)

        binding.svContacts.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(input: String): Boolean {
                return false
            }

            override fun onQueryTextChange(input: String): Boolean {
                filter(input)
                return false
            }
        })

        val permissionWriteContactsLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                findNavController().navigate(R.id.action_contactsFragment_to_newContactFragment)
            } else {
                Snackbar.make(
                    binding.root, getString(R.string.permission_was_denied), Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnAdd.setOnClickListener {
            permissionWriteContactsLauncher.launch(android.Manifest.permission.WRITE_CONTACTS)
        }

        binding.btnSaved.setOnClickListener {
            findNavController().navigate(R.id.action_contactsFragment_to_favoriteContactsFragment)
        }

    }

    private fun filter(text: String) {
        val filteredlist = mutableListOf<ContactModel>()
        if (::myContacts.isInitialized) {
            for (item in myContacts) {
                if (item.userName.lowercase(Locale.getDefault())
                        .contains(text.lowercase(Locale.getDefault()))
                ) {
                    filteredlist.add(item)
                }
            }
        }
        setupRV(filteredlist)
    }

    @SuppressLint("Range")
    private fun readContacts() {
        val cols = listOf(
            ContactsContract.Data.CONTACT_ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.RawContacts.ACCOUNT_TYPE,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.TYPE,
            ContactsContract.CommonDataKinds.Email.DATA,

            ).toTypedArray()

        val filter =
            "" + ContactsContract.Contacts.HAS_PHONE_NUMBER + " > 0 and " + ContactsContract.CommonDataKinds.Phone.TYPE + "=" + ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
        val order =
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"


        val cursor = requireActivity().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cols, filter, null, order
        )

        cursor?.let {
            val contacts = mutableListOf<ContactModel>()

            while (cursor.moveToNext()) {
                val name: String = cursor.getString(1)

                val phoneNumber: String = cursor.getString(3)

                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID))
                    .toInt()

                val emails: Cursor? = requireActivity().contentResolver.query(
                    ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Email.CONTACT_ID
                            + " = " + id, null, null
                )

                var email = ""
                if (emails != null) {
                    if (emails.moveToNext()) {
                        email = emails.getString(
                            emails
                                .getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA)
                        )
                    }
                }

                contacts.add(ContactModel(id, name, phoneNumber, email))

                emails?.close()
            }
            setupRV(contacts)
            myContacts = contacts
        }
        cursor?.close()
    }

    private fun showRationaleDialog(title: String, message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title).setMessage(message)
            .setPositiveButton(getString(R.string.enable)) { _, _ ->

                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts(
                    getString(R.string.package_name),
                    requireActivity().packageName,
                    null
                )
                intent.data = uri
                startActivity(intent)

            }.setNegativeButton(
                getString(R.string.cancel)
            ) { dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }

    private fun setupRV(contacts: List<ContactModel>) {
        val adapter = ContactsAdapter {
            val action = ContactsFragmentDirections.actionContactsFragmentToUserFragment(it)
            findNavController().navigate(action)
        }
        adapter.submitList(contacts)
        binding.rvContacts.adapter = adapter
    }
}
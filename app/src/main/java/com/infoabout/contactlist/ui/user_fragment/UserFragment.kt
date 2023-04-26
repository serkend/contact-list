package com.infoabout.contactlist.ui.user_fragment

import android.content.ContentProviderOperation
import android.content.res.ColorStateList
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.infoabout.contactlist.R
import com.infoabout.contactlist.databinding.FragmentUserBinding
import com.infoabout.contactlist.model.ContactModel
import com.infoabout.contactlist.ui.favorite_contacts.FragmentState
import com.infoabout.contactlist.ui.favorite_contacts.FavoriteContactsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserFragment : Fragment() {

    private val viewModel by viewModels<FavoriteContactsViewModel>()

    private lateinit var binding: FragmentUserBinding
    private val args: UserFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllContacts()
        val contact = args.contact
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.contactsFlow.collect { state ->
                    if (state is FragmentState.SuccessFragmentState) {
                        val idList = state.data.map { it.id }
                        if (idList.contains(contact?.id)) {
                            binding.btnAddToFav.imageTintList = ColorStateList.valueOf(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.blue_star
                                )
                            )
                        }
                    }
                }
            }
        }

        if (contact != null) {
            if (contact.isFavorite) {
                binding.btnAddToFav.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.blue_star
                    )
                )
            } else {
                binding.btnAddToFav.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.gray_star
                    )
                )
            }
        }

        if (contact != null) {
            with(binding) {
                etName.setText(contact.userName)
                etPhone.setText(contact.contactNumber)
                etEmail.setText(contact.email)
            }
        }

        binding.btnAddToFav.setOnClickListener {
            contact?.let { it.isFavorite = !it.isFavorite }

            if (contact != null) {
                if (contact.isFavorite) {
                    binding.btnAddToFav.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.blue_star
                        )
                    )
                    val updatedContact = ContactModel(
                        contact.id,
                        binding.etName.text.toString(),
                        binding.etPhone.text.toString(),
                        binding.etEmail.text.toString()
                    )
                    viewModel.insertContact(updatedContact)
                } else {
                    binding.btnAddToFav.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.gray_star
                        )
                    )
                    viewModel.deleteContact(contact)
                }
            }
        }

        binding.btnUpdate.setOnClickListener {

            val cpo = ArrayList<ContentProviderOperation>()

            cpo.add(
                ContentProviderOperation.newUpdate(ContactsContract.RawContacts.CONTENT_URI)
                    .withSelection(
                        ContactsContract.Data.CONTACT_ID + " = ? ",
                        arrayOf(contact?.id.toString())
                    )
                    .withValue(
                        ContactsContract.Contacts.DISPLAY_NAME,
                        binding.etName.text.toString()
                    )
                    .build()
            )

            val whereNum =
                ContactsContract.Data.DISPLAY_NAME + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?"

            val numParams =
                arrayOf(
                    contact?.userName.toString(),
                    ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
                )

            cpo.add(
                ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                    .withSelection(
                        whereNum,
                        numParams
                    )
                    .withValue(
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        binding.etPhone.text.toString()
                    )
                    .build()
            )

            val where =
                ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?"

            val emailParams =
                arrayOf(
                    contact?.id.toString(),
                    ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE
                )

            cpo.add(
                ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                    .withSelection(
                        where,
                        emailParams
                    )
                    .withValue(
                        ContactsContract.CommonDataKinds.Email.DATA,
                        binding.etEmail.text.toString()
                    )
                    .build()
            )

            try {
                requireActivity().contentResolver.applyBatch(ContactsContract.AUTHORITY, cpo)
                Snackbar.make(
                    binding.root,
                    getString(R.string.updated_successfully),
                    Snackbar.LENGTH_SHORT
                ).show()
                findNavController().navigateUp()
            } catch (e: Exception) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.updating_error),
                    Snackbar.LENGTH_SHORT
                ).show()
                e.printStackTrace()
            }
        }
    }

}
package com.infoabout.contactlist.ui.favorite_contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.infoabout.contactlist.databinding.FragmentFavoriteContactsBinding
import com.infoabout.contactlist.model.ContactModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteContactsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteContactsBinding
    private val viewModel by viewModels<FavoriteContactsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllContacts()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.contactsFlow.collect { state ->
                    when (state) {
                        is FragmentState.SuccessFragmentState -> {
                            binding.tvEmpty.visibility = View.INVISIBLE
                            if (state.data.isEmpty()) {
                                binding.tvEmpty.visibility = View.VISIBLE
                            }
                            setupRV(state.data)
                        }
                        is FragmentState.EmptyFragmentState -> {
                            binding.tvEmpty.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    private fun setupRV(contacts: List<ContactModel>) {
        val adapter = SavedContactsAdapter {
            viewModel.deleteContact(it)
        }
        adapter.submitList(contacts)
        binding.rvSavedContacts.adapter = adapter
    }

}
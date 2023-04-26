package com.infoabout.contactlist.ui.favorite_contacts

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.infoabout.contactlist.R
import com.infoabout.contactlist.databinding.SavedContactRvItemBinding
import com.infoabout.contactlist.model.ContactModel

class SavedContactsAdapter(private val onClicked: (ContactModel) -> Unit) :
    ListAdapter<ContactModel, SavedContactsAdapter.ContactViewHolder>(
        ContactsDiffCallback()
    ) {

    inner class ContactViewHolder(private val binding: SavedContactRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: ContactModel) {
            binding.tvContactName.text = contact.userName
        }

        init {
            binding.btnAddToFavorites.setOnClickListener {
                binding.btnAddToFavorites.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.gray_star
                    )
                )
                onClicked(currentList[adapterPosition])
            }
        }

    }

    class ContactsDiffCallback : DiffUtil.ItemCallback<ContactModel>() {
        override fun areItemsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            SavedContactRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
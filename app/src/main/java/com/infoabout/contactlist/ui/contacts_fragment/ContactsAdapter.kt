package com.infoabout.contactlist.ui.contacts_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.infoabout.contactlist.databinding.ContactRvItemBinding
import com.infoabout.contactlist.model.ContactModel

class ContactsAdapter(private val onClicked: (ContactModel) -> Unit) :
    ListAdapter<ContactModel, ContactsAdapter.ContactViewHolder>(
        ContactsDiffCallback()
    ) {

    inner class ContactViewHolder(private val binding: ContactRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: ContactModel) {
            binding.tvContactName.text = contact.userName
        }

        init {
            binding.root.setOnClickListener {
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
            ContactRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
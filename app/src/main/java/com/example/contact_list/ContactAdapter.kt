package com.example.contact_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_list.databinding.ContactListItemBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    fun setupContacts(contact: List<Contact>){
        this.contacts.addAll(contacts)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ContactViewHolder {
        return ContactViewHolder(
            ContactListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactViewHolder, position: Int) {
        val contact : Contact = contacts[position]
        holder.bindItem(contact)

    }

    override fun getItemCount(): Int {
       return contacts.size
    }

    inner class ContactViewHolder(private val binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindItem(contact: Contact){
            binding.name.text = contact.name
            binding.number.text = contact.number
        }
    }

}
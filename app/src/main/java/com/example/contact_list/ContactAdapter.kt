package com.example.contact_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_list.databinding.ContactListItemBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    inner class ViewHolder(private val binding: ContactItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(contact: Contact){
            binding.name.text = contact.name
            binding.number.text = contact.number
        }
    }

    fun setupContacts(contact: List<Contact>){
        contacts.addAll(contact)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContactItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)

    }

    override fun getItemCount(): Int {
       return contacts.size
    }



}
package dev.ogabek.mayqontaqt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.mayqontaqt.R
import dev.ogabek.mayqontaqt.listener.ItemClickListener
import dev.ogabek.mayqontaqt.model.Contact

class MainAdapter(private var contacts: List<Contact>, val itemClickListener: ItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactPhoto: ImageView = view.findViewById(R.id.iv_contact_photo)
        val contactName: TextView = view.findViewById(R.id.tv_contact_name)
        val contactNumber: TextView = view.findViewById(R.id.tv_contact_number)
        val itemContact: LinearLayout = view.findViewById(R.id.item_contact)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contacts[position]

        if (holder is ItemViewHolder) {
            holder.apply {
                contactPhoto.setImageResource(R.drawable.img_user)
                contactName.text = contact.name
                contactNumber.text = contact.phoneNumber
                itemContact.setOnClickListener {
                    itemClickListener.itemClick(contact)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}
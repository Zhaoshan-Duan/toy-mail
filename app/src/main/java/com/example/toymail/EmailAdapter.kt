package com.example.toymail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.toymail.databinding.ActivityMainBinding

class EmailAdapter(private val emails: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        )
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]
        holder.apply {
            senderTextView.text = email.sender
            titleTextView.text = email.title
            summaryTextView.text = email.summary
        }
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView
        val senderImageView: ImageView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
            senderImageView = itemView.findViewById(R.id.senderIv)
        }

    }
}
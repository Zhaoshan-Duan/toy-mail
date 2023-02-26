package com.example.toymail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toymail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var emails: MutableList<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val emailRv = binding.emailsRv
        emails = EmailFetcher.getEmails()

        val adapter = EmailAdapter(emails)

        val loadMoreBtn = binding.loadMoreBtn

        emailRv.adapter = adapter
        emailRv.layoutManager = LinearLayoutManager(this)

        loadMoreBtn.setOnClickListener {
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notifyDataSetChanged()
        }
        
    }
}
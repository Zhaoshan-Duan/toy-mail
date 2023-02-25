package com.example.toymail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toymail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var emails: List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val emailRv = binding.emailsRv

        emails = EmailFetcher.getEmails()
        emailRv.adapter = EmailAdapter(emails)
        emailRv.layoutManager = LinearLayoutManager(this)


    }
}
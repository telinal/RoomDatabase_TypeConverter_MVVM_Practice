package com.example.roomdatabasepractice_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabasepractice_mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this

        database = ContactDatabase.getDatabase(this)

        database.contactDao().getContact().observe(this, androidx.lifecycle.Observer {
            Log.d("telina", it.toString())
        })

    }

    fun getData() {
        lifecycleScope.launch {
            database.contactDao().insertContact(Contact(0, "Mary", "77777777", Date(), isActive = 1))
        }

    }
}

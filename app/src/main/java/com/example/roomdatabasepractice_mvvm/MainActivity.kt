package com.example.roomdatabasepractice_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.programmingList)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(0, "J", "Java")
        val p2 = ProgrammingItem(1, "A", "Android")
        val p3 = ProgrammingItem(2, "P", "Python")

        adapter.submitList(listOf(p1, p2, p3))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            delay(4000)
            val p1 = ProgrammingItem(0, "J", "Java")
            val p4 = ProgrammingItem(3, "K", "Kotlin")
            val p5 = ProgrammingItem(4, "R", "Ruby")
            val p6 = ProgrammingItem(5, "C", "C++")

adapter.submitList(listOf(p1,p4,p5,p6))
        }

    }
}

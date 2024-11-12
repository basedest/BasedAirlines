package com.basedest.airlines

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.basedest.airlines.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bookTicketButton.setOnClickListener {
            startActivity(Intent(this, TicketOrderActivity::class.java))
        }

        binding.viewOrdersButton.setOnClickListener {
            startActivity(Intent(this, OrderSummaryActivity::class.java))
        }
    }
}
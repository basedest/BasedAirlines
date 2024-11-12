package com.basedest.airlines

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.basedest.airlines.databinding.ActivityTicketOrderBinding
import com.basedest.airlines.viewmodel.TicketViewModel
import com.basedest.airlines.data.Ticket

class TicketOrderActivity : ComponentActivity() {
    private lateinit var binding: ActivityTicketOrderBinding
    private val viewModel: TicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.submitButton.setOnClickListener {
            val ticket = createTicketFromInput()
            viewModel.addTicket(ticket)
            clearInputs()
        }

        binding.viewOrdersButton.setOnClickListener {
            startActivity(Intent(this, OrderSummaryActivity::class.java))
        }
    }

    private fun createTicketFromInput(): Ticket {
        return Ticket(
            passengerName = binding.passengerNameInput.text.toString(),
            isChild = binding.isChildCheckbox.isChecked,
            departureCity = binding.departureCityInput.text.toString(),
            arrivalCity = binding.arrivalCityInput.text.toString(),
            price = binding.priceInput.text.toString().toDoubleOrNull() ?: 0.0,
            date = binding.dateInput.text.toString()
        )
    }

    private fun clearInputs() {
        binding.passengerNameInput.text.clear()
        binding.departureCityInput.text.clear()
        binding.arrivalCityInput.text.clear()
        binding.priceInput.text.clear()
        binding.dateInput.text.clear()
        binding.isChildCheckbox.isChecked = false
    }
}
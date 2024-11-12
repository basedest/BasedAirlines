package com.basedest.airlines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.basedest.airlines.adapter.TicketAdapter
import com.basedest.airlines.databinding.ActivityOrderSummaryBinding
import com.basedest.airlines.viewmodel.TicketViewModel

class OrderSummaryActivity : ComponentActivity() {
    private lateinit var binding: ActivityOrderSummaryBinding
    private lateinit var viewModel: TicketViewModel
    private val adapter = TicketAdapter()
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as AirlinesApplication).ticketViewModel

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.ticketsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@OrderSummaryActivity)
            adapter = this@OrderSummaryActivity.adapter
        }
    }

    private fun observeViewModel() {
        viewModel.tickets.observe(this) { tickets ->
            adapter.updateTickets(tickets)
            updateSummary()
        }
    }

    private fun updateSummary() {
        val totalCost = viewModel.getTotalCost()
        val (adultCount, childCount) = viewModel.getTicketCounts()

        binding.totalCostText.text = "Total Cost: $${String.format("%.2f", totalCost)}"
        binding.ticketCountsText.text = "Adults: $adultCount, Children: $childCount"
    }
}
package com.basedest.airlines.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basedest.airlines.data.Ticket
import com.basedest.airlines.databinding.ItemTicketBinding

class TicketAdapter : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {
    private var tickets = listOf<Ticket>()

    class TicketViewHolder(val binding: ItemTicketBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = ItemTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = tickets[position]
        with(holder.binding) {
            passengerName.text = ticket.passengerName
            route.text = "${ticket.departureCity} → ${ticket.arrivalCity}"
            price.text = "Price: $${ticket.price}"
            passengerType.text = if (ticket.isChild) "Child" else "Adult"
            date.text = ticket.date
        }
    }

    override fun getItemCount() = tickets.size

    fun updateTickets(newTickets: List<Ticket>) {
        tickets = newTickets
        notifyDataSetChanged()
    }
}
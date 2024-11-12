package com.basedest.airlines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basedest.airlines.data.Ticket

class TicketViewModel : ViewModel() {
    private val _tickets = MutableLiveData<List<Ticket>>(emptyList())
    val tickets: LiveData<List<Ticket>> = _tickets

    fun addTicket(ticket: Ticket) {
        val currentList = _tickets.value.orEmpty().toMutableList()
        currentList.add(ticket)
        _tickets.value = currentList
    }

    fun getTotalCost(): Double {
        return tickets.value?.sumOf { it.price } ?: 0.0
    }

    fun getTicketCounts(): Pair<Int, Int> {
        val adultTickets = tickets.value?.count { !it.isChild } ?: 0
        val childTickets = tickets.value?.count { it.isChild } ?: 0
        return Pair(adultTickets, childTickets)
    }
}
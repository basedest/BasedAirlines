// app/src/main/java/com/basedest/airlines/AirlinesApplication.kt
package com.basedest.airlines

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.basedest.airlines.viewmodel.TicketViewModel

class AirlinesApplication : Application(), ViewModelStoreOwner {
    override val viewModelStore: ViewModelStore by lazy {
        ViewModelStore()
    }

    lateinit var ticketViewModel: TicketViewModel

    override fun onCreate() {
        super.onCreate()
        ticketViewModel = TicketViewModel()
    }
}
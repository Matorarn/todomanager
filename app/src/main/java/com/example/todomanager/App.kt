package com.example.todomanager

import android.app.Application
import androidx.room.Room
import com.example.todomanager.data.TicketRepository
import com.example.todomanager.room.TicketDAO
import com.example.todomanager.room.TicketDatabase
import com.example.todomanager.ui.overview.OverviewViewModel
import com.example.todomanager.ui.ticketconfig.TicketConfigViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<TicketDatabase> {
        Room.databaseBuilder(get(), TicketDatabase::class.java, "ticket_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    single<TicketDAO> { get<TicketDatabase>().ticketDao() }
    single<TicketRepository> { TicketRepository(get()) }
    viewModel<OverviewViewModel> { OverviewViewModel(get()) }
    viewModel<TicketConfigViewModel> { TicketConfigViewModel(get()) }
}

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}
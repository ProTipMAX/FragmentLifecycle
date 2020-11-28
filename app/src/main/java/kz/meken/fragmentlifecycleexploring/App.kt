package kz.meken.fragmentlifecycleexploring

import android.app.Application
import kz.meken.fragmentlifecycleexploring.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule
                )
            )
        }
    }
}
package br.com.monteoliva.testesky

import android.app.Application
import br.com.monteoliva.testesky.view.detail.DetailModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

import br.com.monteoliva.testesky.view.main.MainModule

/**
 * Application
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
        }
        MainModule.loadModule()
        DetailModule.loadModule()
    }
}
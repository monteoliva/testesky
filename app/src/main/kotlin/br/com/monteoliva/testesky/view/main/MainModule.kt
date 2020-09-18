package br.com.monteoliva.testesky.view.main

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

import br.com.monteoliva.testesky.view.detail.DetailViewModel

/**
 * Main Module (Object)
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
object MainModule {
    private val mainModule = module {
        viewModel { MainViewModel() }
    }

    fun loadModule() {
        loadKoinModules(
            listOf(
                mainModule
            )
        )
    }
}
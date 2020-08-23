package br.com.monteoliva.testesky.view.detail

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/**
 * Detail Module (Object)
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
object DetailModule {
    private val detailModule = module {
        viewModel { DetailViewModel() }
    }

    fun loadModule() {
        loadKoinModules(
            listOf(
                detailModule
            )
        )
    }
}
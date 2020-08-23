package br.com.monteoliva.testesky.model

import br.com.monteoliva.testesky.model.gson.Master
import com.android.volley.RequestQueue

import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.google.gson.Gson

import br.com.monteoliva.testesky.presenter.MVP
import br.com.monteoliva.testesky.utils.Constantes

/**
 * main Model
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class Model (private val presenter: MVP.Presenter): MVP.Model {
    private lateinit var requestQueue: RequestQueue

    override fun loadList()   { load(Type.LOAD_FIRST)  }
    override fun loadUpdate() { load(Type.LOAD_UPDATE) }

    private fun load(type: Type) {
        if (type == Type.LOAD_FIRST) {
            presenter.showProgressBar(true)
        }

        val request = StringRequest(
            Request.Method.GET,
            Constantes.BASE_URL,
            {
                val line: String = "{\"items\":" + it.trim() + "}"
                val data: Master = Gson().fromJson(line, Master::class.java)

                when(type) {
                    Type.LOAD_FIRST -> presenter.updateListRecycler(data.items)
                    Type.LOAD_UPDATE -> presenter.updateList(data.items)
                }
            },
            {
            }
        )

        requestQueue = Volley.newRequestQueue(presenter.context)
        requestQueue.add(request)
    }

    private enum class Type { LOAD_FIRST, LOAD_UPDATE }
}
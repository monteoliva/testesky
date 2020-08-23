package br.com.monteoliva.testesky.presenter

import android.content.Context
import android.view.View

import br.com.monteoliva.testesky.model.Model
import br.com.monteoliva.testesky.model.gson.Item

/**
 * main Presenter
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class Presenter : MVP.Presenter {
    private lateinit var view: MVP.View

    private val model: MVP.Model = Model(this)

    override val context: Context
        get() = view as Context

    override fun setView(view: MVP.View) { this.view = view }
    override fun showProgressBar(status: Boolean) {
        val visible: Int = if (status) View.VISIBLE else View.GONE
        view.showProgressBar(visible)
    }

    override fun loadList()  { model.loadList() }
    override fun loadUpdate() { model.loadUpdate() }
    override fun updateListRecycler(list: MutableList<Item>?) { view.updateListRecycler(list) }
    override fun updateList(list: MutableList<Item>?) { view.updateList(list) }
}
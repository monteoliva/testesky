package br.com.monteoliva.testesky.presenter

import android.content.Context

import br.com.monteoliva.testesky.model.gson.Item

/**
 * main MVP
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class MVP {

    interface Model {
        fun loadList()
        fun loadUpdate()
    }

    interface Presenter {
        val context: Context
        fun setView(view: View)
        fun showProgressBar(status: Boolean)
        fun loadList()
        fun loadUpdate()
        fun updateListRecycler(list: MutableList<Item>?)
        fun updateList(list: MutableList<Item>?)
    }

    interface View {
        fun showProgressBar(visible: Int)
        fun updateListRecycler(list: MutableList<Item>?)
        fun updateList(list: MutableList<Item>?)
    }
}
package br.com.monteoliva.testesky.view.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

import org.koin.android.viewmodel.ext.android.viewModel

import br.com.monteoliva.testesky.R
import br.com.monteoliva.testesky.model.gson.Item
import br.com.monteoliva.testesky.presenter.MVP
import br.com.monteoliva.testesky.presenter.Presenter
import br.com.monteoliva.testesky.view.BaseActivity
import br.com.monteoliva.testesky.view.detail.DetailActivity
import br.com.monteoliva.testesky.view.main.adapter.ItemAdapter

/**
 * Main Activity
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class MainActivity : BaseActivity(R.layout.activity_main), MVP.View {
    private lateinit var presenter: MVP.Presenter

    private val viewModel: MainViewModel by viewModel()

    override fun initViews(bundle: Bundle?) {
        setupToolBar(R.id.toolbar)
        setActionBarTitle(R.string.app_name)

        presenter = Presenter()
        presenter.setView(this)

        swipeRefresh.setOnRefreshListener {
            presenter.loadUpdate()
        }
    }

    override fun initViewModel() {
        presenter.loadList()
        viewModel.itensLiveData.observe(this, { load(it) })
    }

    override fun back(resultCode: Int) { finish() }
    override fun showProgressBar(visible: Int) {
        when(visible) {
            View.VISIBLE -> mainProgress.show()
            View.GONE    -> mainProgress.hide()
        }
    }

    override fun updateListRecycler(list: MutableList<Item>?) {
        viewModel.setList(list!!)
    }

    override fun updateList(list: MutableList<Item>?) {
        viewModel.updateList(list!!)
        swipeRefresh.isRefreshing = false
    }

    private fun load(list: MutableList<Item>?) {
        Log.d("LOAD","Update Load")
        val lm = GridLayoutManager(this, 2)
        val itemAdapter: ItemAdapter = ItemAdapter(this, list!!)

        rv.apply {
            setHasFixedSize(true)
            layoutManager = lm
            adapter = itemAdapter
        }

        presenter.showProgressBar(false)
    }

    fun detail(item: Item) {
        val bundle = Bundle()
            bundle.putParcelable("ITEM", item)

        val intent = Intent(this, DetailActivity::class.java)
            intent.putExtras(bundle)

        startActivity(intent)
        animLeftToRight()
    }
}
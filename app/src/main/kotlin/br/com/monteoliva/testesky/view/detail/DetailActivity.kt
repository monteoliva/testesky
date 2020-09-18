package br.com.monteoliva.testesky.view.detail

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2

import kotlinx.android.synthetic.main.activity_detail.*

import org.koin.android.viewmodel.ext.android.viewModel


import br.com.monteoliva.testesky.R
import br.com.monteoliva.testesky.model.gson.Item
import br.com.monteoliva.testesky.view.BaseActivity
import br.com.monteoliva.testesky.view.detail.adapter.ImageAdapter

class DetailActivity : BaseActivity(R.layout.activity_detail) {
    private val viewModel: DetailViewModel by viewModel()

    override fun initViews(bundle: Bundle?) {
        setupToolBar(R.id.toolbar)
        setActionBarTitle(R.string.app_name)
        setActionBarHome()
        setActionBarHomeButton()
    }

    override fun initViewModel() {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            viewModel.setData(bundle.getParcelable("ITEM")!!)
        }

        viewModel.detailLiveData.observe(this, { load(it) })
    }

    override fun back(resultCode: Int) { onBackPressed() }

    private fun load(item: Item) {
        detailProgress.show()

        setActionBarSubTitle(item.title!!)

        val playHolder: String = "Duration: ${item.duration}"

        history.text  = item.overview
        duration.text = playHolder

        createPagination(item.backdropsUrl)

        detailProgress.hide()
    }

    private fun createPagination(backdropsUrl: MutableList<String>?) {
        pagination.addPagination(backdropsUrl?.size)
        pagination.position(0)

        val pageAdapter = ImageAdapter(backdropsUrl)

        viewPager.apply {
            adapter = pageAdapter
            currentItem = 0
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    pagination.position(position)
                }
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        back(0)
        return true
    }
}
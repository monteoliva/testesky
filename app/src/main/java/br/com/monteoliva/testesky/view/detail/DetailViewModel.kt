package br.com.monteoliva.testesky.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.monteoliva.testesky.model.gson.Item

/**
 * Detail View Model
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class DetailViewModel : ViewModel() {
    val detailLiveData: MutableLiveData<Item> by lazy {
        MutableLiveData<Item>()
    }

    fun setData(data: Item) {
        if (detailLiveData.value == null) {
            detailLiveData.postValue(data)
        }
    }

    val item: Item get() = detailLiveData.value!!
}
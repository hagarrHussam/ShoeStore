package com.udacity.shoestore

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    fun addShoe(item: Shoe?) {
        if (item != null) {
            shoes.value?.add(item)
        }
    }

    init {
    }

    fun makeShoe() : Shoe {
        return Shoe(
            shoeName.value ?: "",
            shoeSize.value?.toDouble() ?: 0.0,
            shoeCompany.value ?: "",
            shoeDescription.value ?: "")
    }
}
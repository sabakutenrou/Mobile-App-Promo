package com.example.aplikasimobileapppromo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasimobileapppromo.domain.GetPromosUseCase
import com.example.aplikasimobileapppromo.domain.items.PromoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(

    private val getPromosUseCase: GetPromosUseCase

) : ViewModel() {

    private val _promos = MutableLiveData<List<PromoItem>>()
    val promos: LiveData<List<PromoItem>> get() = _promos

    init {
        getPromos()
    }

    fun getPromos() {

        viewModelScope.launch {
            try {
                val promos = getPromosUseCase()
                _promos.value = promos
            } catch (_: Exception) {}
        }

    }

}
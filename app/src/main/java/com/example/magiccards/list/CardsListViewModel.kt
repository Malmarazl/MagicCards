package com.example.magiccards.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magiccards.models.Card
import com.example.magiccards.services.ServiceAdapter
import kotlinx.coroutines.launch
import java.lang.Exception

class CardsListViewModel: ViewModel() {

    private val _cardsList = MutableLiveData<List<Card>>()
    private val _error = MutableLiveData<String>()
    private var _loading = MutableLiveData<Boolean>()

    val cardsList: LiveData<List<Card>>  = _cardsList
    var loading: LiveData<Boolean> = _loading
    val error: LiveData<String> = _error

    fun getCards() {
        viewModelScope.launch {
            connectionToCardService()
        }
    }

    private suspend fun connectionToCardService() {
        try {
            _loading.postValue(true)
            val response = ServiceAdapter.getApiService()?.getCards()
            response?.let {
                _cardsList.postValue(it.cards)
                _loading.postValue(false)
            }?: _error.postValue("Error al cargar el listado de cartas")
        } catch (e: Exception) {
            _loading.postValue(false)
            _error.postValue(e.message)
        }
    }
}
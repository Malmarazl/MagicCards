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

    private val _cardsList: MutableLiveData<List<Card>> = MutableLiveData()
    private val _error = MutableLiveData<String>()

    val cardsList: MutableLiveData<List<Card>>  = _cardsList
    val error: LiveData<String> = _error

    fun getCards() {
        viewModelScope.launch {
            connectionToCardService()
        }
    }

    private suspend fun connectionToCardService() {
        try {
            val response = ServiceAdapter.getApiService()?.getCards()
            _cardsList.postValue(response?.cards)
        } catch (e: Exception) {
            _error.postValue(e.message)
        }
    }
}
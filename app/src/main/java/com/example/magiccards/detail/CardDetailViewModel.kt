package com.example.magiccards.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magiccards.models.Card
import com.example.magiccards.models.ParentCard
import com.example.magiccards.services.ServiceAdapter
import kotlinx.coroutines.launch

class CardDetailViewModel: ViewModel() {

    private val _card = MutableLiveData<Card>()
    private val _error = MutableLiveData<String>()

    val card: LiveData<Card> = _card
    val error: LiveData<String> = _error

    fun getCard(cardID: String) {
        viewModelScope.launch {
            connectionToCardService(cardID)
        }
    }

    private suspend fun connectionToCardService(cardID: String) {
        try {
            val response = ServiceAdapter.getApiService()?.getCardID(cardID)
            response?.let {
                _card.postValue(it.parentCard)
            } ?:  _error.postValue("Ha habido un error al recuperar la carta")
        } catch (e: Exception){
            _error.postValue(e.message)
        }
    }
}
package com.douglasqueiroz.thewallet.feature.currencydetails.logic

import androidx.lifecycle.ViewModel
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.data.local.model.Currency
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyDetailsEvent
import com.douglasqueiroz.thewallet.util.StringResUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CurrencyDetailsViewModel(
    private val currency: Currency? = null,
    private val stringResUtil: StringResUtil
): ViewModel() {

    private val _state = MutableStateFlow(CurrencyDetailsViewState())
    val state = _state.asStateFlow()

    init {
        currency?.let {
            populateCurrency(currency)
        }
    }

    private fun populateCurrency(currency: Currency) {
        _state.value = _state.value.copy(
            currencyName = currency.name,
            currencySymbol =  currency.symbol,
            defaultCurrency = currency.defaultCurrency
        )
    }

    fun onEvent(event: CurrencyDetailsEvent) {
        when(event) {
            is CurrencyDetailsEvent.OnNameChange -> onChangeCurrencyName(event.newValue)
            is CurrencyDetailsEvent.OnCancel -> TODO()
            is CurrencyDetailsEvent.OnSave -> TODO()
            is CurrencyDetailsEvent.OnSymbolChange -> TODO()
        }
    }

    private fun onChangeCurrencyName(name: String) {

        val errorMessage = if (name.isEmpty()) {
            stringResUtil.getString(R.string.mandatory_field_error)
        } else {
            null
        }

        _state.value = _state.value.copy(
            currencyName = name,
            currencyNameErrorMsg = errorMessage
        )
    }

}
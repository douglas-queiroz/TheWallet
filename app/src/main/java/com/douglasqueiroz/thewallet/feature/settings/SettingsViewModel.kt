package com.douglasqueiroz.thewallet.feature.settings

import androidx.lifecycle.ViewModel
import com.douglasqueiroz.thewallet.feature.currencylist.navigateToCurrencyList
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClick
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClickImpl
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter

class SettingsViewModel(
    private val navRouter: NavRouter
): ViewModel(), OnBottomBarClick by OnBottomBarClickImpl(navRouter) {

    fun onEvent(event: SettingsEvent) {

        when(event) {
            SettingsEvent.OnCurrencyClick -> navRouter.navigateToCurrencyList()
        }
    }
}
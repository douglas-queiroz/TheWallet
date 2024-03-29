package com.douglasqueiroz.thewallet.feature.assets

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.douglasqueiroz.thewallet.feature.home.navigateToHome
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import org.koin.androidx.compose.koinViewModel

fun NavRouter.navigateToAssets() {
    val startDestination = this.navHostController.graph.findStartDestination()
    this.navHostController.navigate("assets") {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(startDestination.id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}

fun NavGraphBuilder.assetsScreen() {
    composable("assets") {
        val viewModel = koinViewModel<AssetsViewModel>()
        AssetsScreen(
            onBottomBarClick = viewModel::onBottomBarClick
        )
    }
}
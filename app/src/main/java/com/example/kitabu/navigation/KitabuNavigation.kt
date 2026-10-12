package com.example.kitabu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kitabu.ui.BookDetailsScreen
import com.example.kitabu.ui.CatalogScreen
import com.example.kitabu.ui.HomeScreen
import com.example.kitabu.ui.LoginScreen
import com.example.kitabu.ui.ProfileScreen
import com.example.kitabu.ui.ReservationSuccessScreen
import com.example.kitabu.ui.ReservationsScreen
import com.example.kitabu.ui.WelcomeScreen

object Routes {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val HOME = "home"
    const val CATALOG = "catalog"
    const val BOOK_DETAILS = "book_details/{bookId}"
    const val RESERVATION_SUCCESS = "reservation_success/{bookId}"
    const val RESERVATIONS = "reservations"
    const val PROFILE = "profile"
}

@Composable
fun KitabuNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME
    ) {

        composable(route = Routes.WELCOME) {
            WelcomeScreen(
                onGetStarted = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        composable(route = Routes.LOGIN) {
            LoginScreen(
                onLogin = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Routes.HOME) {
            HomeScreen(
                onCatalog = {
                    navController.navigate(Routes.CATALOG)
                },
                onReservations = {
                    navController.navigate(Routes.RESERVATIONS)
                },
                onProfile = {
                    navController.navigate(Routes.PROFILE)
                }
            )
        }

        composable(route = Routes.CATALOG) {
            CatalogScreen(
                onViewDetails = { bookId ->
                    navController.navigate("book_details/$bookId")
                },
                onReservationSuccess = { bookId ->
                    navController.navigate("reservation_success/$bookId")
                }
            )
        }

        composable(
            route = Routes.BOOK_DETAILS,
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val bookId =
                backStackEntry.arguments?.getInt("bookId") ?: 0

            BookDetailsScreen(
                bookId = bookId,
                onReservationSuccess = {
                    navController.navigate(
                        "reservation_success/$bookId"
                    )
                }
            )
        }

        composable(
            route = Routes.RESERVATION_SUCCESS,
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val bookId =
                backStackEntry.arguments?.getInt("bookId") ?: 0

            ReservationSuccessScreen(
                bookId = bookId,
                onViewReservation = {
                    navController.navigate(Routes.RESERVATIONS) {
                        popUpTo(Routes.RESERVATION_SUCCESS) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Routes.RESERVATIONS) {
            ReservationsScreen()
        }

        composable(route = Routes.PROFILE) {
            ProfileScreen()
        }
    }
}
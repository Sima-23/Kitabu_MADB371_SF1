package com.example.kitabu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.kitabu.navigation.KitabuNavigation
import com.example.kitabu.ui.KitabuTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )

        setContent {

            KitabuTheme {

                val navController =
                    rememberNavController()

                KitabuNavigation(
                    navController = navController
                )
            }
        }
    }
}
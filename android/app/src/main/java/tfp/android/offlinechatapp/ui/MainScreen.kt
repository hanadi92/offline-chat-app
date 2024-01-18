package tfp.android.offlinechatapp.ui

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tfp.android.offlinechatapp.client.ConnectScreen
import tfp.android.offlinechatapp.server.ServerMainScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(navController)
        },
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Server.route) {
        composable(BottomNavigationScreens.Server.route) {
            ServerMainScreen()
        }
        composable(BottomNavigationScreens.Client.route) {
            ConnectScreen()
        }
    }
}

package com.devaeon.todoCompose

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devaeon.todoCompose.tasks.TasksScreen
import com.devaeon.todoCompose.utils.AppModalDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TodoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    startDestination: String = TodoDestinations.TASKS_ROUTE,
    navAction: TodoNavigationActions = remember(navController) { TodoNavigationActions(navController) }
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navController.currentBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(
            route = TodoDestinations.TASKS_ROUTE,
            arguments = listOf(
                navArgument(TodoDestinationsArgs.USER_MESSAGE_ARG) {
                    type = NavType.IntType; defaultValue = 0
                }
            )
        ) { entry ->
            AppModalDrawer(
                drawerState = drawerState,
                currentRoute = currentRoute,
                navigationActions = navAction
            ) {
                TasksScreen(
                    openDrawer = { coroutineScope.launch { drawerState.open() } }
                )
            }
        }
    }


}

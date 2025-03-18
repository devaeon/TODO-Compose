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
import com.devaeon.todoCompose.TodoDestinationsArgs.USER_MESSAGE_ARG
import com.devaeon.todoCompose.statistics.StatisticsScreen
import com.devaeon.todoCompose.tasks.TasksScreen
import com.devaeon.todoCompose.utils.AppModalDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TodoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    startDestination: String = TodoDestinations.TASKS_ROUTE,
    navActions: TodoNavigationActions = remember(navController) { TodoNavigationActions(navController) }
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = TodoDestinations.TASKS_ROUTE,
            arguments = listOf(
                navArgument(USER_MESSAGE_ARG) {
                    type = NavType.IntType; defaultValue = 0
                }
            )
        ) { entry ->
            AppModalDrawer(drawerState, currentRoute, navActions) {
                TasksScreen(
                    userMessage = entry.arguments?.getInt(USER_MESSAGE_ARG)!!,
                    openDrawer = { coroutineScope.launch { drawerState.open() } })
            }
        }

        composable(
            route = TodoDestinations.STATISTICS_ROUTE,
        ) {
            AppModalDrawer(
                drawerState = drawerState,
                currentRoute = currentRoute,
                navigationActions = navActions
            ) {
                StatisticsScreen(
                    openDrawer = { coroutineScope.launch { drawerState.open() } })
            }
        }
    }
}

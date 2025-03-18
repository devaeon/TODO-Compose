package com.devaeon.todoCompose

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.devaeon.todoCompose.TodoDestinationsArgs.USER_MESSAGE_ARG
import com.devaeon.todoCompose.TodoScreens.STATISTICS_SCREEN
import com.devaeon.todoCompose.TodoScreens.TASKS_SCREEN


/**
 * Screens used in [TodoDestinations]
 */
private object TodoScreens {
    const val TASKS_SCREEN = "tasks"
    const val STATISTICS_SCREEN = "statistics"
    }

/**
 * Arguments used in [TodoDestinations] routes
 */
object TodoDestinationsArgs {
    const val USER_MESSAGE_ARG = "userMessage"
}

/**
 * Destinations used in the [MainActivity]
 */
object TodoDestinations {
    const val TASKS_ROUTE = "$TASKS_SCREEN?$USER_MESSAGE_ARG={$USER_MESSAGE_ARG}" //TaskScreen with optional user message parameter
    const val STATISTICS_ROUTE = STATISTICS_SCREEN

}

/**
 * Models the navigation actions in the app.
 */
class TodoNavigationActions(private val navController: NavHostController) {

    fun navigateToTasks(userMessage: Int = 0) {
        val navigatesFromDrawer = userMessage == 0
        navController.navigate(
            TASKS_SCREEN.let {
                if (userMessage != 0) "$it?$USER_MESSAGE_ARG=$userMessage" else it
            }
        ) {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = !navigatesFromDrawer
                saveState = navigatesFromDrawer
            }
            launchSingleTop = true
            restoreState = navigatesFromDrawer
        }
    }

    fun navigateToStatistics() {
        navController.navigate(TodoDestinations.STATISTICS_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

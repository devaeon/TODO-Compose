package com.devaeon.todoCompose

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

    fun navigateToTask(userMessage:Int=0){

    }

    fun navigateToStatistics(){

    }
}

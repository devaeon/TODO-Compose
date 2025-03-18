package com.devaeon.todoCompose.statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.devaeon.todoCompose.R
import com.devaeon.todoCompose.ui.theme.TodoTheme
import com.devaeon.todoCompose.utils.LoadingContent
import com.devaeon.todoCompose.utils.StatisticsTopAppBar


@Composable
fun StatisticsScreen(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
//    viewModel: StatisticsViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = { StatisticsTopAppBar(openDrawer) },
    ) { paddingValues ->
       // val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        StatisticsContent(
            loading = false,
            empty = false,
            activeTasksPercent = 50.0F,
            completedTasksPercent = 50.0F,
            onRefresh = {  },
            modifier = modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun StatisticsContent(
    loading: Boolean,
    empty: Boolean,
    activeTasksPercent: Float,
    completedTasksPercent: Float,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val commonModifier = modifier
        .fillMaxSize()
        .padding(horizontal = dimensionResource(id = R.dimen.horizontal_margin))

    LoadingContent(
        loading = loading,
        empty = empty,
        onRefresh = onRefresh,
        modifier = modifier,
        emptyContent = {
            Text(
                text = stringResource(id = R.string.statistics_no_tasks),
                modifier = commonModifier
            )
        }
    ) {
        Column(
            commonModifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            if (!loading) {
                Text(stringResource(id = R.string.statistics_active_tasks, activeTasksPercent))
                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.list_item_padding)))
                Text(
                    stringResource(
                        id = R.string.statistics_completed_tasks,
                        completedTasksPercent
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun StatisticsContentPreview() {
    TodoTheme {
        Surface {
            StatisticsContent(
                loading = false,
                empty = false,
                activeTasksPercent = 40.0F,
                completedTasksPercent = 60.0f,
                onRefresh = {}
            )
        }
    }
}

@Preview
@Composable
private fun StatisticsScreenPreview() {
    TodoTheme {
        Surface {
            StatisticsScreen({})
        }
    }
}


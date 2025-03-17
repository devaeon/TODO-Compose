package com.devaeon.todoCompose.tasks

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devaeon.todoCompose.R
import com.devaeon.todoCompose.utils.TaskTopAppBar


@Composable
fun TasksScreen(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TaskTopAppBar(openDrawer = openDrawer)
        }
    ) { contentPadding ->
        Log.i(TAG, "TasksScreen: $contentPadding")
        TasksEmptyContent(
            noTasksLabel = R.string.no_tasks_all,
            noTasksIconRes = R.drawable.logo_no_fill
        )
    }
}


@Composable
private fun TasksEmptyContent(
    @StringRes noTasksLabel: Int,
    @DrawableRes noTasksIconRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = noTasksIconRes),
            contentDescription = stringResource(R.string.no_tasks_image_content_description),
            modifier = Modifier.size(96.dp)
        )
        Text(stringResource(id = noTasksLabel))
    }
}


@Preview
@Composable
private fun TaskScreenPreview() {
    TasksScreen(openDrawer = {})
}

private const val TAG = "TasksScreen"
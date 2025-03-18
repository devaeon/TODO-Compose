@file:OptIn(ExperimentalMaterial3Api::class)

package com.devaeon.todoCompose.utils

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.devaeon.todoCompose.R
import com.devaeon.todoCompose.ui.theme.TodoTheme


@Composable
fun TaskTopAppBar(
    openDrawer: () -> Unit
) {
    CustomTopAppBar(
        title = stringResource(id = R.string.list_title),
        openDrawer = openDrawer,
        actions = {
           /* TODO: Implement action later */
        }
    )
}

@Composable
fun StatisticsTopAppBar(openDrawer: () -> Unit) {
    CustomTopAppBar(
        title = stringResource(id = R.string.statistics_title),
        openDrawer = openDrawer
    )
}

@Composable
fun CustomTopAppBar(
    title: String,
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(Icons.Filled.Menu, stringResource(id = R.string.open_drawer))
            }
        },
        actions = actions,
        modifier = modifier.fillMaxWidth()
    )
}


@Preview
@Composable
private fun TaskTopAppBarPreview() {
    TodoTheme {
        Surface {
            TaskTopAppBar(openDrawer = {})
        }
    }
}

@Preview
@Composable
private fun StatisticsTopAppBarPreview() {
    TodoTheme {
        Surface {
            StatisticsTopAppBar(openDrawer = {})
        }
    }
}
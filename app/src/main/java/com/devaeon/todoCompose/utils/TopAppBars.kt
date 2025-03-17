package com.devaeon.todoCompose.utils

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskTopAppBar(
    openDrawer: () -> Unit
) {

    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(Icons.Filled.Menu, stringResource(id = R.string.open_drawer))
            }
        },
        actions = {
            //TODO: Add other menu item actions here in future...
        },
        modifier = Modifier.fillMaxWidth()

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
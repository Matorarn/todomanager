package com.example.todomanager.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.todomanager.ui.overview.State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    mainTitle: String,
    selectedState: State,
    onSelect: (State) -> Unit,
    onShowTicketConfig: () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = mainTitle) },
                scrollBehavior = scrollBehavior,
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedState == State.BACKLOG,
                    onClick = { onSelect(State.BACKLOG) },
                    icon = { Icon(Icons.Default.List, contentDescription = null) },
                )
                NavigationBarItem(
                    selected = selectedState == State.TODO,
                    onClick = { onSelect(State.TODO) },
                    icon = { Icon(Icons.Default.Build, contentDescription = null) },
                )
                NavigationBarItem(
                    selected = selectedState == State.DOING,
                    onClick = { onSelect(State.DOING) },
                    icon = { Icon(Icons.Default.PlayArrow, contentDescription = null) },
                )
                NavigationBarItem(
                    selected = selectedState == State.DONE,
                    onClick = { onSelect(State.DONE) },
                    icon = { Icon(Icons.Default.Check, contentDescription = null) },
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onShowTicketConfig) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        content = content,
    )
}

@Preview
@Composable
private fun MainScaffoldPreview() {
    MainScaffold(
        mainTitle = "To Do",
        selectedState = State.TODO,
        onSelect = {},
        onShowTicketConfig = {},
        content = {},
    )
}
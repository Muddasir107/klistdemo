package com.klitapp.com.ui.theme.genericApi

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


class KList<T> {

    private var padding: Dp = 0.dp
    private var headerTitle: String? = null
    private var items: List<T> = emptyList()
    private var itemContent: @Composable (T) -> Unit = {}

    fun padding(padding: Dp): KList<T> {
        this.padding = padding
        return this
    }

    fun header(title: String): KList<T> {
        this.headerTitle = title
        return this
    }

    fun items(
        items: List<T>,
        itemContent: @Composable (T) -> Unit
    ): KList<T> {
        this.items = items
        this.itemContent = itemContent
        return this
    }

    @Composable
    fun Render() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            headerTitle?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            LazyColumn {
                items(items) { item ->
                    itemContent(item)
                }
            }
        }
    }
}
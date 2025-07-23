package com.klitapp.com.ui.theme.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.klitapp.com.ui.theme.genericApi.KList

@Composable
fun CoinListScreen(listOfCoins: List<String>) {
    KList<String>()
        .padding(10.dp)
        .header("Top Gainers")
        .items(listOfCoins) { coin ->
            KListItem(coin)
        }
        .Render()
}

@Composable
fun KListItem(coin: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = coin,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


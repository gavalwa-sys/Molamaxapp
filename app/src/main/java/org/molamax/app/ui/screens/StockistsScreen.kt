package org.molamax.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.molamax.app.data.MolamaxData
import org.molamax.app.data.Stockist
import org.molamax.app.ui.components.MolaCard
import org.molamax.app.ui.theme.MolaTag
import org.molamax.app.util.dialPhone

@Composable
fun StockistsScreen() {
    val context = LocalContext.current
    LazyColumn(contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp)) {
        item {
            Text("Find Molamax near you", style = MaterialTheme.typography.titleLarge)
            Text(
                "Botswana and Zimbabwe stockist network.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp, bottom = 14.dp)
            )
        }
        items(MolamaxData.stockists) { stockist ->
            StockistRow(stockist) { dialPhone(context, stockist.phone) }
        }
    }
}

@Composable
private fun StockistRow(stockist: Stockist, onCall: () -> Unit) {
    MolaCard(Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(stockist.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    "${stockist.town}, ${stockist.country}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Button(
                onClick = onCall,
                colors = ButtonDefaults.buttonColors(containerColor = MolaTag, contentColor = MaterialTheme.colorScheme.onBackground)
            ) { Text("Call") }
        }
    }
}

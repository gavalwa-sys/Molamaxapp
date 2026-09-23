package org.molamax.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.molamax.app.data.MolamaxData
import org.molamax.app.data.Product
import org.molamax.app.ui.components.FlowTags
import org.molamax.app.ui.components.MolaCard
import org.molamax.app.ui.components.PillTag
import org.molamax.app.ui.theme.MolaRed
import org.molamax.app.util.openUrl

@Composable
fun ProductsScreen() {
    var selected by remember { mutableStateOf("all") }
    val context = LocalContext.current

    Column {
        Text(
            "Solutions for every production goal",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 2.dp)
        )
        Text(
            "Focused support for the animals you care for every day.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = 18.dp, end = 18.dp, bottom = 10.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FilterChip(
                    selected = selected == "all",
                    onClick = { selected = "all" },
                    label = { Text("All") },
                    colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MolaRed)
                )
            }
            items(MolamaxData.categories) { cat ->
                FilterChip(
                    selected = selected == cat.slug,
                    onClick = { selected = cat.slug },
                    label = { Text("${cat.emoji} ${cat.name}") },
                    colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MolaRed)
                )
            }
        }

        val filtered = if (selected == "all") MolamaxData.products
        else MolamaxData.products.filter { it.categorySlug == selected }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filtered) { product ->
                ProductCard(product) {
                    openUrl(context, MolamaxData.whatsappUrl(
                        "Hello Molamax, I would like a quote for ${product.name}."
                    ))
                }
            }
        }
    }
}

@Composable
private fun ProductCard(product: Product, onAsk: () -> Unit) {
    MolaCard(Modifier.fillMaxWidth()) {
        PillTag(product.categoryName)
        Text(
            product.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        Text(
            product.tagline,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Column(Modifier.padding(top = 8.dp, bottom = 4.dp)) {
            FlowTags(product.suitableFor)
        }
        TextButton(onClick = onAsk, contentPadding = PaddingValues(0.dp)) {
            Text("Ask about this product \u2192", color = MolaRed, style = MaterialTheme.typography.labelLarge)
        }
    }
}

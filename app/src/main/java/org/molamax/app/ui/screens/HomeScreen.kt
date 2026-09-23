package org.molamax.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.molamax.app.data.MolamaxData
import org.molamax.app.ui.components.Eyebrow
import org.molamax.app.ui.components.MolaCard
import org.molamax.app.ui.theme.MolaDark
import org.molamax.app.ui.theme.MolaRed
import org.molamax.app.util.openUrl

@Composable
fun HomeScreen(onExploreProducts: () -> Unit) {
    val context = LocalContext.current
    LazyColumn(
        contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(Brush.verticalGradient(listOf(MolaDark, androidx.compose.ui.graphics.Color(0xFF26301F))))
                    .padding(20.dp)
            ) {
                Column {
                    Eyebrow(MolamaxData.heroEyebrow)
                    Text(
                        MolamaxData.heroTagline,
                        color = androidx.compose.ui.graphics.Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(top = 8.dp, bottom = 10.dp)
                    )
                    Text(
                        MolamaxData.heroBody,
                        color = androidx.compose.ui.graphics.Color(0xFFDBE3D5),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Row(Modifier.padding(top = 16.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = onExploreProducts,
                            colors = ButtonDefaults.buttonColors(containerColor = MolaRed)
                        ) { Text("Explore products") }
                        OutlinedButton(onClick = {
                            openUrl(context, MolamaxData.whatsappUrl(
                                "Hello Molamax, I need help with animal health products."
                            ))
                        }) { Text("Request a quote", color = androidx.compose.ui.graphics.Color.White) }
                    }
                }
            }
        }

        item {
            Column(Modifier.padding(18.dp)) {
                Text(MolamaxData.aboutTitle, style = MaterialTheme.typography.titleLarge)
                Text(
                    MolamaxData.aboutBody,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )
                FeatureRow("\uD83C\uDF3F", "Organic solutions", "Targeted support for digestion, immunity and productivity.")
                FeatureRow("\uD83E\uDDEA", "Technical support", "Practical answers for your herd or flock.")
                FeatureRow("\uD83D\uDCCD", "Regional reach", "Zimbabwe and Botswana stockist network.")
            }
        }

        item {
            Column(Modifier.padding(horizontal = 18.dp)) {
                Text("Solutions for every production goal", style = MaterialTheme.typography.titleLarge)
                Text(
                    "From early chick immunity to rumen efficiency.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
                )
            }
        }

        items(MolamaxData.categories) { category ->
            Box(Modifier.padding(horizontal = 18.dp, vertical = 6.dp)) {
                MolaCard(Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(category.emoji, style = MaterialTheme.typography.headlineMedium)
                        Column(Modifier.padding(start = 12.dp)) {
                            Text(category.name, style = MaterialTheme.typography.titleMedium)
                            Text(
                                category.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FeatureRow(emoji: String, title: String, body: String) {
    Row(Modifier.padding(bottom = 14.dp), verticalAlignment = Alignment.Top) {
        Box(
            Modifier
                .size(38.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) { Text(emoji) }
        Column(Modifier.padding(start = 12.dp)) {
            Text(title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
            Text(body, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

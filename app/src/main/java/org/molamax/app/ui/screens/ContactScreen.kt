package org.molamax.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.molamax.app.data.MolamaxData
import org.molamax.app.ui.components.MolaCard
import org.molamax.app.util.dialPhone
import org.molamax.app.util.openUrl
import org.molamax.app.util.sendEmail

private data class ContactAction(val emoji: String, val title: String, val subtitle: String, val action: (android.content.Context) -> Unit)

@Composable
fun ContactScreen() {
    val context = LocalContext.current
    val actions = listOf(
        ContactAction("\uD83D\uDCDE", MolamaxData.generalPhone, "General enquiries") { dialPhone(it, MolamaxData.generalPhone) },
        ContactAction("\uD83D\uDCDE", MolamaxData.zimbabwePhone, "Zimbabwe") { dialPhone(it, MolamaxData.zimbabwePhone) },
        ContactAction("\uD83D\uDCDE", MolamaxData.botswanaPhone, "Botswana") { dialPhone(it, MolamaxData.botswanaPhone) },
        ContactAction("\u2709\uFE0F", MolamaxData.email, "Email us") { sendEmail(it, MolamaxData.email) },
        ContactAction("\uD83D\uDCAC", "WhatsApp Molamax", "Chat with our team") {
            openUrl(it, MolamaxData.whatsappUrl("Hello Molamax, I need help with animal health products."))
        }
    )

    LazyColumn(contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp)) {
        item {
            Text("Talk to the Molamax team", style = MaterialTheme.typography.titleLarge)
            Text(
                "Ask about products, availability, or technical support. ${MolamaxData.workingHours}.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp, bottom = 14.dp)
            )
        }
        items(actions) { action ->
            MolaCard(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .clickable { action.action(context) }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(action.emoji, style = MaterialTheme.typography.titleLarge)
                    Column(Modifier.padding(start = 12.dp)) {
                        Text(action.title, style = MaterialTheme.typography.titleMedium)
                        Text(
                            action.subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

package org.molamax.app.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.molamax.app.data.Faq
import org.molamax.app.data.MolamaxData
import org.molamax.app.ui.components.MolaCard
import org.molamax.app.ui.components.PillTag
import org.molamax.app.ui.theme.MolaRed

@Composable
fun LearnScreen() {
    LazyColumn(contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp)) {
        item {
            Text("Latest farming guidance", style = MaterialTheme.typography.titleLarge)
            Text(
                "From the Knowledge Centre.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
            )
        }
        items(MolamaxData.articles) { article ->
            Column(Modifier.padding(vertical = 10.dp)) {
                PillTag(article.category)
                Text(
                    article.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 6.dp, bottom = 4.dp)
                )
                Text(
                    article.excerpt,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Divider(color = MaterialTheme.colorScheme.outline)
        }

        item {
            Text(
                "Frequently asked questions",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 24.dp, bottom = 2.dp)
            )
            Text(
                "Answers before you ask.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        val faqsByCategory = MolamaxData.faqs.groupBy { it.category }
        faqsByCategory.forEach { (category, faqs) ->
            item {
                Text(
                    category.uppercase(),
                    style = MaterialTheme.typography.labelLarge,
                    color = MolaRed,
                    modifier = Modifier.padding(top = 10.dp, bottom = 6.dp)
                )
            }
            items(faqs) { faq -> FaqItem(faq) }
        }
    }
}

@Composable
private fun FaqItem(faq: Faq) {
    var expanded by remember { mutableStateOf(false) }
    MolaCard(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .animateContentSize()
            .clickable { expanded = !expanded }
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                faq.question,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = null
            )
        }
        if (expanded) {
            Text(
                faq.answer,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

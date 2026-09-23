```kotlin
package org.molamax.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Eyebrow(text: String) {
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.labelLarge.copy(fontSize = 11.5.sp),
        color = MaterialTheme.colorScheme.primary,
        letterSpacing = 0.8.sp
    )
}

@Composable
fun PillTag(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(999.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.dp),
        style = MaterialTheme.typography.bodySmall,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
fun SectionTitle(title: String, subtitle: String? = null) {
    Column {
        Text(
            title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        if (subtitle != null) {
            Text(
                subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun MolaCard(
    modifier: Modifier = Modifier,
    content: ColumnScopeContent
) {
    Card(
        modifier = modifier.border(
            1.dp,
            MaterialTheme.colorScheme.outline,
            RoundedCornerShape(14.dp)
        ),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            Modifier.padding(15.dp),
            content = content
        )
    }
}

typealias ColumnScopeContent =
    @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit

@Composable
fun FlowTags(tags: List<String>) {
    // Simple wrapping row substitute using chunks of 2-3
    // to avoid an extra dependency on FlowRow.
    val rows = tags.chunked(2)

    Column {
        rows.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(bottom = 6.dp)
            ) {
                row.forEach {
                    PillTag(it)
                }
            }
        }
    }
}
```

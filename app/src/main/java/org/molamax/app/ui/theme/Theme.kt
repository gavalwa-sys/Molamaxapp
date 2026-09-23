package org.molamax.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = MolaRed,
    onPrimary = Color(0xFFFFFFFF),
    background = MolaBg,
    onBackground = MolaDark,
    surface = MolaCard,
    onSurface = MolaDark,
    surfaceVariant = MolaTag,
    outline = MolaLine
)

private val DarkColors = darkColorScheme(
    primary = MolaRed,
    onPrimary = Color(0xFFFFFFFF),
    background = MolaDarkBg,
    onBackground = MolaDarkOnBg,
    surface = MolaDarkCard,
    onSurface = MolaDarkOnBg,
    surfaceVariant = MolaDarkTag,
    outline = MolaDarkLine
)

private val MolaTypography = Typography(
    headlineMedium = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp, lineHeight = 30.sp),
    titleLarge = TextStyle(fontWeight = FontWeight.Bold, fontSize = 19.sp),
    titleMedium = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = TextStyle(fontSize = 12.5.sp, lineHeight = 18.sp),
    labelLarge = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
)

@Composable
fun MolamaxTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(colorScheme = colors, typography = MolaTypography, content = content)
}

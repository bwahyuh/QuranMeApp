package com.bwahyuh.quranme.compose.ui.foundation.text

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.bwahyuh.quranme.compose.ui.theme.AlifThemes
import com.bwahyuh.quranme.compose.ui.theme.Black
import com.bwahyuh.quranme.compose.ui.theme.Primary
import com.bwahyuh.quranme.compose.ui.theme.White

@Composable
fun TextSubtitle(
    modifier: Modifier? = Modifier,
    text: String,
    textColor: Color? = null,
    textStyle: TextStyle? = null,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier ?: Modifier,
        text = text,
        color = textColor ?: if (isSystemInDarkTheme()) White else Black,
        textAlign = textAlign,
        style = textStyle ?: AlifThemes.Typography.subtitle
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTextSubtitle() {
    MaterialTheme {
        TextSubtitle(text = "Add new schedule", textColor = Primary)
    }
}
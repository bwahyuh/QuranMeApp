package com.bwahyuh.quranme.compose.page

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bwahyuh.quranme.compose.state.QuranUiState
import com.bwahyuh.quranme.compose.state.SurahUiState
import com.bwahyuh.quranme.compose.ui.navigation.QuranNavType
import com.bwahyuh.quranme.data.model.Surah
import com.bwahyuh.quranme.ui.quran.SurahActivity
import com.bwahyuh.quranme.ui.quran.SurahViewModel

@Composable
fun QuranOnly(
    quranUiState: QuranUiState
) {
    val context = LocalContext.current
    QuranPage(quranUiState.onBack) {
        QuranContent(modifier = it.weight(1f), quranUiState, QuranNavType.BottomNav) { surah ->
            context.startActivity(Intent(context, SurahActivity::class.java).apply {
                putExtra(SurahActivity.EXTRA_SURAH, surah)
            })
        }
    }
}

@Composable
fun QuranAndSurah(
    quranUiState: QuranUiState,
    surahUiState: SurahUiState,
    navType: QuranNavType,
    onGetAyahFromSurah: (index: Int) -> Unit,
    onSetSurah: (surah: Surah) -> Unit,
    onInitMedia: (surah: Surah) -> Unit,
) {
    QuranPage(quranUiState.onBack) {
        QuranContent(modifier = it.weight(1.1f), quranUiState, navType) { surah ->
            onGetAyahFromSurah(surah.index)
            onSetSurah(surah)
            onInitMedia(surah)
        }
        SurahContent(modifier = it.weight(0.9f), surahUiState = surahUiState)
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
private fun PreviewQuranAndSurah() {
    val surahViewModel = hiltViewModel<SurahViewModel>()
    QuranAndSurah(
        quranUiState = QuranUiState(),
        SurahUiState(),
        QuranNavType.NavRail,
        surahViewModel::getAyahFromSurah,
        surahViewModel::setSurah
    ) {}
}
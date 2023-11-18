package com.bwahyuh.quranme.ui.quran

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint
import com.bwahyuh.quranme.compose.page.SurahPage
import com.bwahyuh.quranme.compose.ui.theme.AlifTheme
import com.bwahyuh.quranme.data.model.Surah

@AndroidEntryPoint
class SurahActivity : BaseAudioSurahActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlifTheme {
                val uiState = surahViewModel.uiState.collectAsState().value
                SurahPage(uiState)
            }
        }
        intent.extras?.getParcelable<Surah>(EXTRA_SURAH)?.let {
            surahViewModel.getAyahFromSurah(it.index)
            surahViewModel.setSurah(it)
            surahViewModel.setCallBack(this::onBack, this::onMediaStart, this::onMediaPause)
            initMediaPlayer(it)
        }
    }

    private fun onBack() = finish()

    companion object {
        const val EXTRA_SURAH = "extra_surah"
    }
}
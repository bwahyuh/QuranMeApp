package com.bwahyuh.quranme.compose.state

import com.bwahyuh.quranme.data.model.Juz
import com.bwahyuh.quranme.data.model.Surah

data class QuranUiState(
    var listSurah: List<Surah> = emptyList(),
    var listJuz: List<Juz> = emptyList(),
    var onBack: () -> Unit = {}
)
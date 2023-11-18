package com.bwahyuh.quranme.compose.state

import com.bwahyuh.quranme.data.model.Ayah
import com.bwahyuh.quranme.data.model.Surah

data class SurahUiState(
    var surah: Surah = Surah.empty,
    var listAyah: List<Ayah> = emptyList(),
    var audioProgress: Float = 0f,
    var currentDurationPosition: Int = 0,
    var isFinish: Boolean? = null,
    var onBack: () -> Unit = {},
    var onStart: (progress: Float, position: Int) -> Unit = { _, _ -> },
    var onPause: () -> Unit = {}
)

data class SurahOnlyUiState(
    var surah: Surah = Surah.empty,
    var listAyah: List<Ayah> = emptyList(),
)

package com.bwahyuh.quranme.ui.quran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.bwahyuh.quranme.compose.state.SurahUiState
import com.bwahyuh.quranme.data.model.Ayah
import com.bwahyuh.quranme.data.model.Surah
import com.bwahyuh.quranme.repo.PrayerRepository
import com.bwahyuh.quranme.repo.States
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val repository: PrayerRepository
) : ViewModel() {

    private val currentUiState = SurahUiState()
    private val _uiState = MutableStateFlow(currentUiState)
    val uiState = _uiState


    fun setCallBack(
        onBack: () -> Unit,
        onStart: (progress: Float, position: Int) -> Unit,
        onPause: () -> Unit
    ) {
        _uiState.value = uiState.value.copy(
            onBack = onBack,
            onStart = onStart,
            onPause = onPause
        )
    }

    fun setSurah(surah: Surah) {
        _uiState.value = uiState.value.copy(surah = surah)
    }

    fun setAudioProgress(progress: Float) {
        _uiState.value = uiState.value.copy(audioProgress = progress)
    }

    fun setCurrentDurationPosition(position: Int) {
        _uiState.value = uiState.value.copy(currentDurationPosition = position)
    }

    fun setFinish(finish: Boolean?) {
        _uiState.value = uiState.value.copy(isFinish = finish)
    }

    fun getAyahFromSurah(noSurah: Int) {
        viewModelScope.launch {
            repository.getAyahQuran(noSurah).collect {
                if (it is States.Success) {
                    setAyah(it.data)
                }
            }
        }
    }

    private fun setAyah(listAyah: List<Ayah>) {
        _uiState.value = uiState.value.copy(listAyah = listAyah)
    }
}
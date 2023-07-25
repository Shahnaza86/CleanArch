package com.example.cleanarch.presentation.ui.fragments.music

import androidx.lifecycle.viewModelScope
import com.example.cleanarch.domain.models.Music
import com.example.cleanarch.domain.usecases.AddMusicUseCase
import com.example.cleanarch.domain.usecases.GetMusicByDurationUseCase
import com.example.cleanarch.domain.usecases.GetMusicByPerfomerUseCase
import com.example.cleanarch.domain.usecases.GetMusicUseCase
import com.example.cleanarch.presentation.ui.base.BaseViewModel
import com.example.cleanarch.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val getMusicUseCase: GetMusicUseCase,
    private val getMusicByPerfomerUseCase: GetMusicByPerfomerUseCase,
    private val getMusicByDurationUseCase: GetMusicByDurationUseCase,
    private val addMusicUseCase: AddMusicUseCase,
) : BaseViewModel() {

    private val _getAllMusicState = MutableStateFlow<UiState<List<Music>>>(UiState.EmptyState())
    val getAllMusicStates = _getAllMusicState.asStateFlow()

    fun addMusic(music: Music){
        viewModelScope.launch(Dispatchers.IO) {
            addMusicUseCase.execute(music)
        }
    }

    fun getAllMusic() = getMusicUseCase.execute().collectData(_getAllMusicState)

    fun getMusicByPerfomer() = getMusicByPerfomerUseCase.execute().collectData(_getAllMusicState)

    fun getMusicByDuration() = getMusicByDurationUseCase.execute().collectData(_getAllMusicState)
}}
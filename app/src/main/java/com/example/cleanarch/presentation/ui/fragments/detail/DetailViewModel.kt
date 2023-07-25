package com.example.cleanarch.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarch.domain.models.Music
import com.example.cleanarch.domain.usecases.DeleteMusicUseCase
import com.example.cleanarch.domain.usecases.UpdateMusicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateMusicUseCase: UpdateMusicUseCase,
    private val deleteMusicUseCase: DeleteMusicUseCase
) : ViewModel() {

    suspend fun updateMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            updateMusicUseCase.execute(music)
        }
    }

    suspend fun deleteMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteMusicUseCase.execute(music)
        }
    }
}
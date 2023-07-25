package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.models.Music
import com.example.cleanarch.domain.repositories.MusicRepository
import javax.inject.Inject

class DeleteMusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    suspend fun execute(music: Music) {
        musicRepository.deleteMusic(music = music)
    }
}
package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.models.Music
import com.example.cleanarch.domain.repositories.MusicRepository
import com.example.cleanarch.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMusicByDurationUseCase @Inject constructor(private val musicRepository: MusicRepository) {

    fun execute(): Flow<Resource<List<Music>>> = musicRepository.getMusicsByDuration()

}
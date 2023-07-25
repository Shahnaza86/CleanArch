package com.example.cleanarch.data.repositories

import com.example.cleanarch.data.base.BaseRepository
import com.example.cleanarch.data.local.MusicDao
import com.example.cleanarch.data.models.toEntity
import com.example.cleanarch.data.models.toMusic
import com.example.cleanarch.domain.models.Music
import com.example.cleanarch.domain.repositories.MusicRepository
import com.example.cleanarch.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(private val musicDao: MusicDao) : BaseRepository(),
    MusicRepository {
    override suspend fun addMusic(music: Music) {
        musicDao.addMusic(music.toEntity())
    }

    override suspend fun updateMusic(music: Music){
        musicDao.updateMusic(music.toEntity())    }

    override suspend fun deleteMusic(music: Music){
        musicDao.deleteMusic(music.toEntity())
    }

    override fun getMusics(): Flow<Resource<List<Music>>> = doRequest { musicDao.getMusics().map { it.toMusic() } }

    override fun getMusicsByPerfomer(): Flow<Resource<List<Music>>>  = doRequest { musicDao.getMusicByPerfomer().map { it.toMusic() } }

    override fun getMusicsByDuration(): Flow<Resource<List<Music>>> = doRequest { musicDao.getMusicByDuration().map { it.toMusic() } }
}
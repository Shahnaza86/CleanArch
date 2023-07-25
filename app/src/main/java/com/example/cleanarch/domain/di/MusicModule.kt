package com.example.cleanarch.domain.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarch.data.local.MusicDao
import com.example.cleanarch.data.local.MusicDataBase
import com.example.cleanarch.data.repositories.MusicRepositoryImpl
import com.example.cleanarch.domain.repositories.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MusicModule {

    @Singleton
    @Provides
    fun provideMusicDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        MusicDataBase::class.java,
        "music"
    ).build()

    @Provides
    fun provideMusicDao(musicDataBase: MusicDataBase) = musicDataBase.musicDao()

    @Provides
    fun provideMusicRepository(musicDao: MusicDao): MusicRepository {
        return MusicRepositoryImpl(musicDao = musicDao)
    }
}
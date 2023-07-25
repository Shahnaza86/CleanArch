package com.example.cleanarch.data.models

import com.example.cleanarch.domain.models.Music

fun Music.toEntity() : MusicEntity {
    return MusicEntity(id, name, perfomer, duration)
}

fun MusicEntity.toMusic() : Music {
    return Music(id, name, perfomer, duration)
}
//fun List<MusicEntity>.toMusic() = map {
//    Music(
//        id = it.id,
//        name = it.name,
//        perfomer = it.perfomer,
//        duration = it.duration
//    )
//}
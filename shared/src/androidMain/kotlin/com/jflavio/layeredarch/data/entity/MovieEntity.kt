package com.jflavio.layeredarch.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * MovieEntity
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
@Entity
class MovieEntity(
    @PrimaryKey val localId: Int = -1,
    @ColumnInfo(name = "id", index = true) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "durationInMinutes") val durationInMinutes: Int,
    @ColumnInfo(name = "posterUrl") val posterUrl: String
)
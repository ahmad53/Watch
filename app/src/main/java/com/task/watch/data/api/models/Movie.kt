package com.task.watch.data.api.models

import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.task.watch.utils.Category
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie",indices = [Index("id"),Index("category")],
    primaryKeys = ["id","category"])
data class Movie(
    @SerializedName("id")
    var id: Long = 0,

    @SerializedName("title")
    var title: String? = null,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String? = null,

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Double? = 0.0,

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    var voteCount: Int = 0,

    @SerializedName("original_language")
    var language: String? = null,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    var releaseDate: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("popularity")
    var popularity:Double=0.0,

    @ColumnInfo(name = "category")
    var categoryType: Category = Category.POPULAR

):Parcelable{
}

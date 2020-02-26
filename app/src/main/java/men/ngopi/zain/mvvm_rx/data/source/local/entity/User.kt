package men.ngopi.zain.mvvm_rx.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserEntity")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "name")
    @SerializedName("login")
    val name: String? = null,

    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    val avatar: String? = null,

    @ColumnInfo(name = "url")
    @SerializedName("url")
    val url: String? = null
)
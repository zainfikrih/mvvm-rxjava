package men.ngopi.zain.mvvm_rx.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val name: String? = null,

    @SerializedName("avatar_url")
    val avatar: String? = null,

    @SerializedName("url")
    val url: String? = null
)
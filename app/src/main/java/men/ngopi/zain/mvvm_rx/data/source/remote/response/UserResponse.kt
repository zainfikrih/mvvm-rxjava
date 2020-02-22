package men.ngopi.zain.mvvm_rx.data.source.remote.response

import com.google.gson.annotations.SerializedName
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User

data class UserResponse(
    @SerializedName("total_count")
    val totalCount: Int? = null,

    @SerializedName("items")
    val users: List<User>? = null
)
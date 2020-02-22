package men.ngopi.zain.mvvm_rx.data.source.remote.retrofit

import io.reactivex.Flowable
import men.ngopi.zain.mvvm_rx.data.source.remote.response.UserResponse
import retrofit2.http.GET

interface RetrofitServices {

    @GET("search/users?q=tom&page=2")
    fun getFlowableUsers(): Flowable<UserResponse>
}
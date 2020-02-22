package men.ngopi.zain.mvvm_rx.data.source.remote

import io.reactivex.Flowable
import men.ngopi.zain.mvvm_rx.data.source.remote.response.UserResponse
import men.ngopi.zain.mvvm_rx.data.source.remote.retrofit.RetrofitServices
import men.ngopi.zain.mvvm_rx.data.source.remote.retrofit.RetrofitSetup

object RemoteRepository {
    private lateinit var service: RetrofitServices

    init {
        val retrofit = RetrofitSetup
        service = retrofit.getRetrofit().create(RetrofitServices::class.java)
    }

    fun getFlowableUsers(): Flowable<UserResponse> {
        return service.getFlowableUsers()
    }
}
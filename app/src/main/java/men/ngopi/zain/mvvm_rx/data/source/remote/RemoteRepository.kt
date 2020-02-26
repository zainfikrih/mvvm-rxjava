package men.ngopi.zain.mvvm_rx.data.source.remote

import io.reactivex.Flowable
import men.ngopi.zain.mvvm_rx.data.source.remote.response.UserResponse
import men.ngopi.zain.mvvm_rx.data.source.remote.retrofit.RetrofitServices

class RemoteRepository(services: RetrofitServices) {
    private val service = services

    fun getFlowableUsers(): Flowable<UserResponse> {
        return service.getFlowableUsers()
    }
}
package men.ngopi.zain.mvvm_rx.data.source

import io.reactivex.Flowable
import men.ngopi.zain.mvvm_rx.data.source.local.entity.Resource
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User

interface DataSource {
    fun getFlowableUsers(): Flowable<Resource<List<User>>?>
}
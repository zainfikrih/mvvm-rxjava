package men.ngopi.zain.mvvm_rx.data.source

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import men.ngopi.zain.mvvm_rx.data.source.local.entity.Resource
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User
import men.ngopi.zain.mvvm_rx.data.source.remote.RemoteRepository

object Repository : DataSource {
    //    private var localRepository: LocalRepository = LocalRepository
    private var remoteRepository: RemoteRepository = RemoteRepository

    override fun getFlowableUsers(): Flowable<Resource<List<User>>?> {
        return remoteRepository.getFlowableUsers()
            .doOnNext {
                Resource.loading(it)
            }
            .map {
                Resource.success(it.users)
            }
            .onErrorReturn {
                Resource.error(it.message)
            }
            .subscribeOn(Schedulers.io())
    }
}
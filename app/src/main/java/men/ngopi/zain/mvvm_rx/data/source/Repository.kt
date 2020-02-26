package men.ngopi.zain.mvvm_rx.data.source

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import men.ngopi.zain.mvvm_rx.data.source.local.LocalRepository
import men.ngopi.zain.mvvm_rx.data.source.local.entity.Resource
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User
import men.ngopi.zain.mvvm_rx.data.source.remote.RemoteRepository

class Repository(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) :
    DataSource {
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
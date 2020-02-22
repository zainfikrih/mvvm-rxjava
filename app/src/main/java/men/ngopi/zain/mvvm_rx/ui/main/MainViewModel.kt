package men.ngopi.zain.mvvm_rx.ui.main

import androidx.lifecycle.*
import men.ngopi.zain.mvvm_rx.data.source.Repository
import men.ngopi.zain.mvvm_rx.data.source.local.entity.Resource
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val repository = Repository

    fun getFlowableUsers(): LiveData<Resource<List<User>>> {
        val users = MediatorLiveData<Resource<List<User>>>()

        val usersFromRemote = LiveDataReactiveStreams.fromPublisher(
            repository.getFlowableUsers()
        )

        users.addSource(usersFromRemote) {
            users.value = it
            users.removeSource(usersFromRemote)
        }

        return users
    }
}
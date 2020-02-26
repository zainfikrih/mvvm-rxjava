package men.ngopi.zain.mvvm_rx.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import men.ngopi.zain.mvvm_rx.data.source.Repository

class ViewModelFactory(
    private val repository: Repository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        try {
            val ctor =
                modelClass.getConstructor(Repository::class.java, SavedStateHandle::class.java)
            return ctor.newInstance(repository, handle)
        } catch (e: Exception) {
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
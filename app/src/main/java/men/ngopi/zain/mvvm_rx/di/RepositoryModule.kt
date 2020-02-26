package men.ngopi.zain.mvvm_rx.di

import dagger.Module
import dagger.Provides
import men.ngopi.zain.mvvm_rx.data.source.Repository
import men.ngopi.zain.mvvm_rx.data.source.local.LocalRepository
import men.ngopi.zain.mvvm_rx.data.source.remote.RemoteRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(
        localRepository: LocalRepository,
        remoteRepository: RemoteRepository
    ): Repository {
        return Repository(localRepository, remoteRepository)
    }

}
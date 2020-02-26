package men.ngopi.zain.mvvm_rx.di

import dagger.Module
import dagger.Provides
import men.ngopi.zain.mvvm_rx.data.source.remote.RemoteRepository
import men.ngopi.zain.mvvm_rx.data.source.remote.retrofit.RetrofitServices
import javax.inject.Singleton

@Module
class RemoteRepositoryModule {

    @Singleton
    @Provides
    fun providesRemoteRepository(services: RetrofitServices): RemoteRepository {
        return RemoteRepository(services)
    }

}
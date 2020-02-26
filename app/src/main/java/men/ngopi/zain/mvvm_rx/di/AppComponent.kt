package men.ngopi.zain.mvvm_rx.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import men.ngopi.zain.mvvm_rx.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ContextModule::class,
        LocalRepositoryModule::class,
        RemoteRepositoryModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

}
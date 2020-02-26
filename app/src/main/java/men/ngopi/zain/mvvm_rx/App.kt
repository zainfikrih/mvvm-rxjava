package men.ngopi.zain.mvvm_rx

import android.app.Application
import men.ngopi.zain.mvvm_rx.di.AppComponent
import men.ngopi.zain.mvvm_rx.di.DaggerAppComponent


class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
    }
}

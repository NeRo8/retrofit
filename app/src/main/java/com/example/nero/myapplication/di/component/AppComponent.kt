package com.example.nero.myapplication.di.component

import android.app.Application
import com.example.nero.myapplication.di.MyApp
import com.example.nero.myapplication.di.module.ActivityModule
import com.example.nero.myapplication.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApp: MyApp)
}
package com.example.nero.myapplication.di.component

import com.example.nero.myapplication.di.MyApplication
import com.example.nero.myapplication.di.module.ActivityModule
import com.example.nero.myapplication.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (NetworkModule::class), (ActivityModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(myApplication: MyApplication): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)
}
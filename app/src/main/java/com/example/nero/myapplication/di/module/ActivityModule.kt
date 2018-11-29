package com.example.nero.myapplication.di.module

import com.example.nero.myapplication.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}
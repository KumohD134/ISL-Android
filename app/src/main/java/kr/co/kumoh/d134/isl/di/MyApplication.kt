package kr.co.kumoh.d134.isl.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {   // Singleton Component: 앱이 살아있는 동안 Dependency 제공

}
package kr.co.kumoh.d134.isl.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.kumoh.d134.isl.repository.ISLInterface
import kr.co.kumoh.d134.isl.repository.ISLRepository

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideISLRepository() : ISLInterface{
        return ISLRepository()
    }
}
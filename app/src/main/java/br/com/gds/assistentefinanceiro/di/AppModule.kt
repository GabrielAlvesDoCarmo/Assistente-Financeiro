package br.com.gds.assistentefinanceiro.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
data object AppModule {
    @Provides
    @Singleton // Garante uma única instância
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context

}
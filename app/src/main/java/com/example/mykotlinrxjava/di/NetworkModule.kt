package com.example.mykotlinrxjava.utils
import com.example.mykotlinrxjava.retrofit.GameApi
import com.example.mykotlinrxjava.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit(
    ) : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerFakerAPI(retrofit: Retrofit) : GameApi {
        return retrofit.create(GameApi::class.java)
    }
}
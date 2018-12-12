package com.shani.sport.beastmode.di;

import android.arch.lifecycle.ViewModelProvider;

import com.shani.sport.beastmode.viewmodel.ProjectViewModelFactory;
import com.shani.sport.beastmode.webservice.WgerExerciseService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton
    @Provides
    WgerExerciseService provideExerciseService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl(WgerExerciseService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(WgerExerciseService.class);

    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }
}
package com.duque.listamvvm.di;

import com.duque.listamvvm.Api.CountriesApi;
import com.duque.listamvvm.Api.CountriesServices;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModulo {

    @Provides
    public CountriesApi providesApi(){

        return new Retrofit.Builder()
                .baseUrl("https://5e5ea581b5c43c0014ef9323.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountriesApi.class);
    }
}

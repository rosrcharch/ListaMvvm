package com.duque.listamvvm.Api;

import com.duque.listamvvm.di.DaggerDataComponent;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesServices {

        public static CountriesServices instance;

        @Inject
        public CountriesApi api;

        public CountriesServices() {

                DaggerDataComponent.create().inject(this);

        }


        public static CountriesServices getInstance(){
                if (instance == null){
                        instance = new CountriesServices();
                }
                return instance;
        }


}

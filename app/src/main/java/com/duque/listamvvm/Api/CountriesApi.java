package com.duque.listamvvm.Api;


import com.duque.listamvvm.Model.CountriesModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CountriesApi {

    @GET("Countries")
    Call<List<CountriesModel>> getCountries();

    @POST("Countries")
    Call<List<CountriesModel>> setCountries(@Body CountriesModel countriesModel);
}

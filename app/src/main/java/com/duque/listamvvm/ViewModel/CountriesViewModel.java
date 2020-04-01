package com.duque.listamvvm.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.duque.listamvvm.Model.CountriesModel;
import com.duque.listamvvm.Api.CountriesServices;
import com.duque.listamvvm.di.DaggerDataComponent;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesViewModel extends ViewModel {

        public MutableLiveData<List<CountriesModel>> countries = new MutableLiveData<List<CountriesModel>>();
        public CountriesServices countriesServices = new CountriesServices().getInstance();
        @Inject
        public CountriesModel countriesModel;

        public CountriesViewModel(){
            DaggerDataComponent.create().inject(this);
        }

    public void loadCountries(){

                Call<List<CountriesModel>> call = countriesServices.api.getCountries();
                call.enqueue(new Callback<List<CountriesModel>>() {
                    @Override
                    public void onResponse(Call<List<CountriesModel>> call, Response<List<CountriesModel>> response) {
                        countries.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<CountriesModel>> call, Throwable t) {
                        countries.setValue(null);

                    }
                });


    }

    public void setPaises(){

        Call<List<CountriesModel>> call = countriesServices.api.setCountries(countriesModel);
        call.enqueue(new Callback<List<CountriesModel>>() {
            @Override
            public void onResponse(Call<List<CountriesModel>> call, Response<List<CountriesModel>> response) {
                    countries.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<CountriesModel>> call, Throwable t) {
                    countries.setValue(null);
            }
        });

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Error", "onCleared Called");
    }
}

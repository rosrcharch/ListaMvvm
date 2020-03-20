package com.duque.listamvvm.di;

import com.duque.listamvvm.Api.CountriesServices;
import com.duque.listamvvm.ViewModel.CountriesViewModel;

import dagger.Component;

@Component(modules = {DataModulo.class})
public interface DataComponent {

    void inject(CountriesServices countriesServices);

    void inject(CountriesViewModel viewModel);
}

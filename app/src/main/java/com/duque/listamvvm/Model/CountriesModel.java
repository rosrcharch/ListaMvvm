package com.duque.listamvvm.Model;

import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class CountriesModel {

    @SerializedName("name")
    private String nameCountry;
    @SerializedName("capital")
    private String capital;
    @SerializedName("flagPNG")
    private String flag = "nulo";

    @Inject
    public CountriesModel() {
    }

    public CountriesModel(String nameCountry, String capital, String flag) {
        this.nameCountry = nameCountry;
        this.capital = capital;
        this.flag = flag;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


}

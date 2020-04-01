package com.duque.listamvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.duque.listamvvm.Model.CountriesModel;
import com.duque.listamvvm.R;
import com.duque.listamvvm.ViewModel.CountriesViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    CountriesViewModel viewModel;
    @BindView(R.id.adicionar)
    Button adicionar;
    @BindView(R.id.nome)
    EditText nome;
    @BindView(R.id.capital)
    EditText capital;
    @BindView(R.id.bandeira)
    EditText banderia;
    private CountriesListAdapter adapter = new CountriesListAdapter(new ArrayList<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializador do ButterKnife
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);
        //Trazer lista de paises
        viewModel.loadCountries();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        observerSetCountries();

        adicionar.setOnClickListener(v -> {
            viewModel.countriesModel.setNameCountry(nome.getText().toString());
            viewModel.countriesModel.setCapital(capital.getText().toString());

            if (banderia.getText().toString().isEmpty()){
                Toast.makeText(this, "Picasso vazio", Toast.LENGTH_SHORT).show();
            }else{
                viewModel.countriesModel.setFlag(banderia.getText().toString());
                //adicionando o Pais na lista
                viewModel.setPaises();
            }
            viewModel.loadCountries();
        });


    }

    public void observerViewModel(){
        viewModel.countries.observe(this, new Observer<List<CountriesModel>>() {
            @Override
            public void onChanged(List<CountriesModel> countryModels) {
                if (countryModels != null) {
                    recyclerView.setVisibility(View.VISIBLE);
                    adapter.updateCounries(countryModels);
                }
            }
        });
    }

    public void observerSetCountries(){
        viewModel.countries.observe(this, (List<CountriesModel> countryModels) -> {
            if (countryModels != null){
                recyclerView.setVisibility(View.VISIBLE);
                adapter.updateCounries(countryModels);
            }
        });

    }
}

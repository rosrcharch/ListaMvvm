package com.duque.listamvvm.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.duque.listamvvm.Model.CountriesModel;
import com.duque.listamvvm.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesListAdapter  extends RecyclerView.Adapter<CountriesListAdapter.MyViewHolder>{

    public List<CountriesModel> countries;

    public CountriesListAdapter(List<CountriesModel> countriesList) {
        this.countries = countriesList;
    }

    public void updateCounries(List<CountriesModel> newCountries){
        countries.clear();
        countries.addAll(newCountries);
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(countries.get(position));

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView flag;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.capital)
        TextView capital;
        private Context context;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(CountriesModel country){

            name.setText(country.getNameCountry());
            capital.setText(country.getCapital());
            Picasso.get().load(country.getFlag()).into(flag);

        }
    }
}

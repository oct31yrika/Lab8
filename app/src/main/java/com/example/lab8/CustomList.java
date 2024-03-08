package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * this check if a city is in the list
     * @ param city
     */
    public boolean hasCity(City newCity) {
        for (City city : cities) {
            if (city.hashCode() == newCity.hashCode()) {
                if (city.equals(newCity)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    /**
     * This method first checks if the city parameter has already in the citylist,
     * if yes, then remove it from the list; else, throw an Illegal Argument Exception.
     * @param newCity   A city object that the user wants to delete from the list
     */
    public void deleteCity(City newCity){
        if (hasCity(newCity)){
            cities.remove(newCity);
        } else {
            throw new IllegalArgumentException();
        }
    }

}

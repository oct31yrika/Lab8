package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declare the variables so that you will be able to reference it later.
    ListView cityList;
    ArrayAdapter<City> cityAdapter;
    ArrayList<City> cityDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        cityDataList = new ArrayList<>();

        cityDataList.add(new City(1,"Edmonton","AB"));
        cityDataList.add(new City(2, "Vancouver","BC"));
        cityDataList.add(new City(3, "Toronto","ON"));
        cityDataList.add(new City(4, "Hamilton","ON"));
        cityDataList.add(new City(5, "Calgary","AB"));
        cityDataList.add(new City(6, "Waterloo","ON"));


        cityAdapter = new CustomList(this,cityDataList);
        cityList.setAdapter(cityAdapter);

    }
}
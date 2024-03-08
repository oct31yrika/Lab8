package com.example.lab8;

import androidx.annotation.Nullable;

public class City implements Comparable{

    private  int id;
    private String city;
    private String province;

    public City(int id, String city, String province){
        this.id = id;
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * This method return the id of the city
     *
     * @return An int represented the hashcode of a city
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * This method supports the city object to be compared
     * It compares objects based on city name
     *
     * @param o the object to be compared.
     * @return The result of the comparison
     * @see java.lang.Comparable
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    // below function borrows ideas from
    // "Comparing Java objects with equals() and hashcode()"
    // author: Rafael del Nero, time: AUG 22, 2019 3:36 PM PDT,
    // publication by: www.infoworld.com
    // URL:https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html
    /**
     * This method checks if the instance equals the parameter
     * It compares their reference, their class, their id, their name, and their province name
     *
     * @param obj the object to be compared.
     * @return The result of the comparison
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        City newCity = (City) obj;
        return id == newCity.hashCode() &&
                city.equals(newCity.getCityName()) &&
                province.equals(newCity.getProvinceName());

    }
}

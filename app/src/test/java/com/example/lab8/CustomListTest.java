package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * create a new city object
     * add a new city object into list
     * and call hasCity method to see if it exists.
     */
    public void hasCityTest(){
        list = MockCityList();
        City city_a = new City("Regina", "Saskatchewan");
        list.add(city_a);
        assertTrue(list.hasCity(city_a));

        City city_b = new City("Regina", "Saskatchewan");
        assertTrue(list.hasCity(city_b));

        City city_c = new City("Regina", "Saskatchewan");
        assertFalse(list.hasCity(city_c));

        City city_d = new City("Charlottetown", "Prince Edward Island");
        assertFalse(list.hasCity(city_d));
    }
}

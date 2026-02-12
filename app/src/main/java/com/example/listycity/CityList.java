package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city dos not already exist
     * @param city
     *          This is a candidate city to add
     * @throws IllegalArgumentException
     *          If the candidate city is already in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *          Return the sorted list
     * */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Given a city, this returns whether or not it is in the list
     * @param city
     *          This is the city to check for
     * @return
     *          Whether or not the city is in the list
     */
    public boolean hasCity(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if ((city.hashCode() == cities.get(i).hashCode()) && city.equals(cities.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given a city, this returns whether or not it is in the list
     * @param city
     *          This is the city selected for deletion
     * @throws NoSuchElementException
     * `        If the city does not exist in the list
     */
    public void deleteCity(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if ((city.hashCode() == cities.get(i).hashCode()) && city.equals(cities.get(i))) {
                cities.remove(cities.get(i));
                return;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * This returns the number of cities in the CityList
     * @return
     * `        The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}

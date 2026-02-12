package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));  //
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHas() {
        CityList cityList = mockCityList();
        City city1 = mockCity();
        assertTrue(cityList.hasCity(city1));
        City city2 = new City("Athens", "Greece");
        assertFalse(cityList.hasCity(city2));
        cityList.add(city2);
        City city3 = new City("Athens", "Georgia");
        assertFalse(cityList.hasCity(city3));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        cityList.deleteCity(mockCity());
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        assertThrows(NoSuchElementException.class, () -> {
            cityList.deleteCity(new City("Something", "Other"));
        });
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    void testCount() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.deleteCity(mockCity());
        assertEquals(0, cityList.countCities());
        for (int i = 0; i < 10; i++) {
            cityList.add(new City(String.format("City_%d", i), "Somewhere"));
        }
        assertEquals(10, cityList.countCities());
    }
}

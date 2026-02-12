package com.example.listycity;

/**
 * This is a class that defines a city
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * City constructor: creates a city with name and province.
     * @param city
     * @param province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city
     * @return
     *      The city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Returns the name of the province
     * @return
     *      the province name.
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city and establishes natural ordering based on names
     * @param o
     *          the reference object with which to compare.
     * @return
     *          Integer result from comparing this city to another
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Compares the city to any object to check for equivalence based on city name and province.
     * @param o
     *          The reference object with which to compare.
     * @return
     *          Whether or not they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City cityObj = (City) o;
        return this.city.equals(cityObj.city) && this.province.equals(cityObj.province);
    }

    /**
     * Generates hashcode based on name of city
     * @return
     *          Hashcode generated from city name
     */
    @Override
    public int hashCode() {
        return this.city.hashCode();  // Hashcode surjective if equals checks equivalence
    }
}

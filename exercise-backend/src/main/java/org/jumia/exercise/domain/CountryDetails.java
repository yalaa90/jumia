package org.jumia.exercise.domain;

/**
 * Country Details class
 */
public class CountryDetails {
    private final String countryName;
    private final String regex;

    public CountryDetails(String countryName, String regex) {
        this.countryName = countryName;
        this.regex = regex;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegex() {
        return regex;
    }
}

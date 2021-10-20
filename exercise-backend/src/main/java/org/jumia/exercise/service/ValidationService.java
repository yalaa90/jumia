package org.jumia.exercise.service;

import org.jumia.exercise.domain.CountryDetails;

import java.util.HashMap;
import java.util.Map;

public class ValidationService {
    public static final Map<String, CountryDetails> countriesMap;

    static {
        countriesMap = new HashMap<>();
        countriesMap.put("237", new CountryDetails("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$"));
        countriesMap.put("251", new CountryDetails("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$"));
        countriesMap.put("212", new CountryDetails("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$"));
        countriesMap.put("258", new CountryDetails("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$"));
        countriesMap.put("256", new CountryDetails("Uganda", "\\(256\\)\\ ?\\d{9}$"));
    }

    /**
     * phone validation
     *
     * @param phoneNumber
     * @return boolean
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (!countriesMap.containsKey(getCountryCode(phoneNumber))) {
            return false;
        }
        CountryDetails country = countriesMap.get(getCountryCode(phoneNumber));
        return phoneNumber.matches(country.getRegex());
    }

    /**
     * phone validation
     *
     * @param phoneNumber
     * @return boolean
     */
    public static boolean isNotValidPhoneNumber(String phoneNumber) {
        if (!countriesMap.containsKey(getCountryCode(phoneNumber))) {
            return false;
        }
        CountryDetails country = countriesMap.get(getCountryCode(phoneNumber));
        return !phoneNumber.matches(country.getRegex());
    }

    /**
     * get country based on code
     *
     * @param phoneNumber
     * @return String
     */
    public static String getCountryCode(String phoneNumber) {
        if (iNullOrNotEmptyString(phoneNumber) || !phoneNumber.contains("(") || !phoneNumber.contains(")")) {
            return "";
        }
        return phoneNumber.substring(phoneNumber.indexOf("(") + 1, phoneNumber.indexOf(")"));
    }

    /**
     * get country based on Name
     *
     * @param phoneNumber
     * @return String
     */
    public static String getCountryName(String phoneNumber) {
        if (!countriesMap.containsKey(getCountryCode(phoneNumber))) {
            return null;
        }
        CountryDetails country = countriesMap.get(getCountryCode(phoneNumber));
        return country.getCountryName();
    }

    /**
     * null validation
     *
     * @param value
     * @return boolean
     */
    public static boolean isNotNullOrNotEmptyString(final String value) {
        if (null == value) {
            return false;
        }
        return !value.trim().isEmpty();
    }

    /**
     * null validation
     *
     * @param value
     * @return boolean
     */
    public static boolean iNullOrNotEmptyString(final String value) {
        if (null == value) {
            return true;
        }

        return value.trim().isEmpty();
    }
}

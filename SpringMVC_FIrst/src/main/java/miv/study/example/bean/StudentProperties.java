package miv.study.example.bean;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class StudentProperties {

    private static List<String> countryOptions;
    private static List<String> languageOptions;

    static {
        countryOptions = new LinkedList<>();
        countryOptions.add( "Brazil");
        countryOptions.add( "France");
        countryOptions.add( "Germany");
        countryOptions.add( "India");
        countryOptions.add( "Russia");
        countryOptions.add( "USA");
        countryOptions.add( "Great Britain");
    }
    static {
        languageOptions = new LinkedList<>();
        languageOptions.add("Java");
        languageOptions.add("C#");
        languageOptions.add("Python");
        languageOptions.add("Ruby");
        languageOptions.add("PHP");
        languageOptions.add("JavaScript");
    }

    public static List<String> getCountriesList() {
        return countryOptions;
    }

    public static List<String> getLanguageOptions() {
        return languageOptions;
    }
}

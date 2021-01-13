package miv.study.example.bean;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Countries {

//    private static LinkedHashMap<String, String> countryOptions;
    private static LinkedList<String> countryOptions;

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

    public static LinkedList<String> getCountriesList() {
        return countryOptions;
    }
}

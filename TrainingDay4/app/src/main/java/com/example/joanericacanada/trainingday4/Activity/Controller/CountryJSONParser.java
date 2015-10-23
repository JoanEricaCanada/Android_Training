package com.example.joanericacanada.trainingday4.Activity.Controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by joanericacanada on 10/22/15.
 */
public class CountryJSONParser {

    public List<HashMap<String,String>> parse(JSONObject jObject){

        JSONArray jCountries = null;
        try {
            jCountries = jObject.getJSONArray("countries");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getCountries(jCountries);
    }

    private List<HashMap<String, String>> getCountries(JSONArray jCountries){
        int countryCount = jCountries.length();
        List<HashMap<String, String>> countryList = new ArrayList<>();
        HashMap<String, String> country;

        for(int i=0; i<countryCount;i++){
            try {
                country = getCountry((JSONObject)jCountries.get(i));
                countryList.add(country);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return countryList;
    }

    private HashMap<String, String> getCountry(JSONObject jCountry){

        HashMap<String, String> country = new HashMap<>();
        String countryName;
        String flag;

        try {
            countryName = jCountry.getString("countryname");
            flag = jCountry.getString("flag");

            country.put("country", countryName);
            country.put("flag", flag);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return country;
    }
}
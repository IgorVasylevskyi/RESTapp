package com.example.restapp.connection;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parsing {

    public static double UAH;
    public static double EUR;
    public static double GBP;

    public static Date date;

    public static String parse(String responceApiText) throws JSONException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        JSONObject rate = new JSONObject(responceApiText);
        JSONObject currencies = rate.getJSONObject("rates");

        for (int i = 0; i < currencies.length(); i++) {
            UAH = currencies.getDouble("UAH");
            EUR = currencies.getDouble("EUR");
            GBP = currencies.getDouble("GBP");
        }

        long timestamp = rate.getLong("time_last_updated");
        date = new Date(timestamp * 1000);


        System.out.println("Rates to USD for date: " + dateFormat.format(date));
        System.out.println("UAH: " + UAH);
        System.out.println("EUR: " + EUR);
        System.out.println("GBP: " + GBP);

        return null;
    }
}

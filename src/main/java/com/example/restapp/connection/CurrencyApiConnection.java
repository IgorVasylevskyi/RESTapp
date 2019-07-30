package com.example.restapp.connection;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;


public class CurrencyApiConnection {

    public static HttpURLConnection connection;

    public static void connection() throws IOException, JSONException, ParseException {

        BufferedReader reader;
        String line;
        StringBuffer responceApiText = new StringBuffer();

        URL url = new URL("https://api.exchangerate-api.com/v4/latest/usd");

        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();

        if (status > 299){
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while ((line = reader.readLine()) != null){
                responceApiText.append(line);
            }
            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null){
                responceApiText.append(line);
            }
            reader.close();
        }

        Parsing.parse(responceApiText.toString());

    }


}

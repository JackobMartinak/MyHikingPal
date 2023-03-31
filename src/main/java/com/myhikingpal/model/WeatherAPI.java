package com.myhikingpal.model;

import java.net.*;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class WeatherAPI {
    
    public JsonObject getJsonWeather(String city) {
        try {
            URL url = new URL(String.format("http://api.weatherapi.com/v1/forecast.json?key=8409bf0c373c45b3b6b174106233103&q=bratislava&days=1&aqi=no&alerts=no", city)); // Replace with your API endpoint
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET"); // Replace with the appropriate HTTP method
            con.connect();
            int status = con.getResponseCode(); // Check the response code to handle errors
            if(status != 200){
                throw new RuntimeException("HttpResponseCode: " + status);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){
                    inline += scanner.nextLine();
                    System.out.println(inline);
                }

                scanner.close();

                // Parse the JSON response using Gson

                JsonObject responseJson = JsonParser.parseString(inline).getAsJsonObject();
            
                // Access the response fields as needed
                // JsonObject obj = (JsonObject) responseJson.get("location");
                //   int field2 = responseJson.get("field2").getAsInt();
                return responseJson;
                // Process the response data as needed
                // System.out.println("field1: " + obj.get("name"));
                //   System.out.println("field2: " + field2);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
      }

}

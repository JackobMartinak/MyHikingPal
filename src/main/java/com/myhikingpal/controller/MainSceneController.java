package com.myhikingpal.controller;

import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.myhikingpal.model.WeatherAPI;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainSceneController {
    @FXML
    Text welcomeLabel;
    @FXML
    Text timeText;
    @FXML
    Text firstHour;
    @FXML
    Text secondHour;
    @FXML
    Text thirdHour;
    @FXML
    Text fourthHour;
    @FXML
    Text cityLocation;
    @FXML
    Text tempNow;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Timeline timeline;
    private WeatherAPI wApi = new WeatherAPI();

    public void initialize(){
        try{
            timeline = new Timeline(new KeyFrame(Duration.seconds(0.9), event -> {
                    LocalTime time = LocalTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String formattedtime = time.format(myFormatObj);
                    timeText.setText(formattedtime);
                }));

                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();

        } catch (Exception e){

        }
    }


    public void displayName(String username) {
        try {
            String replacment = "\\d*\\w-\\d*\\w-\\d*\\s";
            welcomeLabel.setText(username);

            JsonObject weather = wApi.getJsonWeather("Bratislava");
            JsonObject weatherLocation = (JsonObject) weather.get("location");
            JsonObject weatherNow = (JsonObject) weather.get("current").getAsJsonObject();

            JsonArray weatherForcast = (JsonArray) weather.getAsJsonObject("forecast").getAsJsonArray("forecastday").get(0).getAsJsonObject().getAsJsonArray("hour");
            
            // String test = JsonPath.read(null, username, null)
            
            // System.out.println(test);

            cityLocation.setText(weatherLocation.get("name").getAsString());
            tempNow.setText(weatherNow.get("temp_c").getAsString());

            firstHour.setText(String.format("%s\t| %s °C\t|\t %s", 
                weatherForcast.get(0)
                .getAsJsonObject()
                .get("time").getAsString().replaceAll(replacment, ""),
                weatherForcast.get(0)
                .getAsJsonObject()
                .get("temp_c").getAsString(),
                weatherForcast.get(0)
                .getAsJsonObject()
                .getAsJsonObject("condition").get("text").getAsString()
                )); 
            
            secondHour.setText(String.format("%s\t| %s °C\t|\t %s", 
                weatherForcast.get(1)
                .getAsJsonObject()
                .get("time").getAsString().replaceAll(replacment, ""),
                weatherForcast.get(1)
                .getAsJsonObject()
                .get("temp_c").getAsString(),
                weatherForcast.get(1)
                .getAsJsonObject()
                .getAsJsonObject("condition").get("text").getAsString()
                ));
            
            thirdHour.setText(String.format("%s\t| %s °C\t|\t %s", 
                weatherForcast.get(2)
                .getAsJsonObject()
                .get("time").getAsString().replaceAll(replacment, ""),
                weatherForcast.get(2)
                .getAsJsonObject()
                .get("temp_c").getAsString(),
                weatherForcast.get(2)
                .getAsJsonObject()
                .getAsJsonObject("condition").get("text").getAsString()
                ));  

            fourthHour.setText(String.format("%s\t| %s °C\t|\t %s", 
                weatherForcast.get(3)
                .getAsJsonObject()
                .get("time").getAsString().replaceAll(replacment, ""),
                weatherForcast.get(3)
                .getAsJsonObject()
                .get("temp_c").getAsString(),
                weatherForcast.get(3)
                .getAsJsonObject()
                .getAsJsonObject("condition").get("text").getAsString()
                ));
            // secondHour.setText(String.format("%s | %s °C| %s |", 
            //     weatherForcast.get(0).getAsString(), 
            //     weatherForcast.get(0).getAsString()));
            // thirdHour.setText(String.format("%s | %s °C| %s |", 
            //     weatherNow.get("temp_c").getAsString(), 
            //     weatherNow.getAsJsonObject("condition").get("text").getAsString()));   
            // fourthHour.setText(String.format("%s | %s °C| %s |", 
            //     weatherNow.get("temp_c").getAsString(), 
            //     weatherNow.getAsJsonObject("condition").get("text").getAsString()));   
            
            // System.out.println(items.get(0));

            // items.add(weather.get("country").getAsString());
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void switchToLoginScene(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("../gui/LoginScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

        } catch(Exception e) {

        }
    }
}

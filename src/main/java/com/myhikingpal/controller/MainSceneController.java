package com.myhikingpal.controller;

import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    ImageView weatherIcon;

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

    private void weatherShow(){
        String replacment = "\\d*\\w-\\d*\\w-\\d*\\s";
        LocalTime time = LocalTime.now();
        int hourTime = time.getHour();

        JsonObject weather = wApi.getJsonWeather("Bratislava");
        JsonObject weatherLocation = (JsonObject) weather.get("location");
        JsonObject weatherNow = (JsonObject) weather.get("current").getAsJsonObject();

        JsonArray weatherForcast = (JsonArray) weather.getAsJsonObject("forecast").getAsJsonArray("forecastday").get(0).getAsJsonObject().getAsJsonArray("hour");
        String[] regexRes =  (weatherNow.getAsJsonObject("condition").get("icon").getAsString()).split("/");

        // for(int i = 0; i < regexRes.length; i++){
            // System.out.println(String.format("%d - %s", i, regexRes[i]));    String.format("../view/icons/%s", regexRes[6])
        // }
       

        cityLocation.setText(weatherLocation.get("name").getAsString());
        tempNow.setText(weatherNow.get("temp_c").getAsString());

        if(hourTime <= 20){
            firstHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            )); 
        
        secondHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        
        thirdHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime+2)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime+2)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime+2)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));  

        fourthHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime+3)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime+3)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime+3)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        } else if (hourTime == 21) {
            firstHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            )); 
        
        secondHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        
        thirdHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime+2)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime+2)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime+2)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));  

        fourthHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime-21)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime-21)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime-21)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        } else if (hourTime == 22) {
            firstHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            )); 
        
        secondHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime+1)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        
        thirdHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime-22)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime-22)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime-22)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));  

        fourthHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(Math.abs(hourTime-23))
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(Math.abs(hourTime-23))
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(Math.abs(hourTime-23))
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        } else if (hourTime == 23) {
            firstHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(hourTime)
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            )); 
        
        secondHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(Math.abs(hourTime-23))
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(Math.abs(hourTime-23))
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(Math.abs(hourTime-23))
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        
        thirdHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(Math.abs(hourTime-24))
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(Math.abs(hourTime-24))
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(Math.abs(hourTime-24))
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));  

        fourthHour.setText(String.format("%s\t| %s °C\t|\t %s", 
            weatherForcast.get(Math.abs(hourTime-25))
            .getAsJsonObject()
            .get("time").getAsString().replaceAll(replacment, ""),
            weatherForcast.get(Math.abs(hourTime-25))
            .getAsJsonObject()
            .get("temp_c").getAsString(),
            weatherForcast.get(Math.abs(hourTime-25))
            .getAsJsonObject()
            .getAsJsonObject("condition").get("text").getAsString()
            ));
        } 
        

        Image img = new Image(getClass().getResourceAsStream(String.format("../view/icons/%s", regexRes[6])));

        weatherIcon.setImage(img);
    }

    public void displayName(String username) {
        try {
            
            welcomeLabel.setText(username);

            weatherShow();

            
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

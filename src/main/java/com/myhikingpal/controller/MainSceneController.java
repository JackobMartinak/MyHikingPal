package com.myhikingpal.controller;

import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainSceneController {
    @FXML
    Text welcomeLabel;
    @FXML
    Text timeText;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Timeline timeline;

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
            welcomeLabel.setText(username);
            
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

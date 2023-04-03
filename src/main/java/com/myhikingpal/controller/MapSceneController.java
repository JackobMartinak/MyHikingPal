package com.myhikingpal.controller;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;

import javafx.scene.web.WebView;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myhikingpal.model.DbConnection;

public class MapSceneController {
   
   @FXML 
    WebView mapView;

    private Stage stage;
    private Scene scene;
    private Parent root;
    // private Timeline timeline;
    
    @FXML
    public void initialize(){
        try{
            // timeline = new Timeline(new KeyFrame(Duration.seconds(0.9), event -> {
            //         LocalTime time = LocalTime.now();
            //         DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
            //         String formattedtime = time.format(myFormatObj);
            //         timeText.setText(formattedtime);
            //     }));

            //     timeline.setCycleCount(Animation.INDEFINITE);
            //     timeline.play();
            //     weatherShow();

            // mapView.getEngine().loadContent("/src/main/java/com/myhikingpal/view/gui/map.html");

            // String initMap = "function initMap() {"
            // + "var map = new google.maps.Map(document.getElementById('map'), {"
            // + "center: {lat: 37.7749, lng: -122.4194},"
            // + "zoom: 8"
            // + "});"
            // + "}";

            // mapView.getEngine().getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            //         mapView.getEngine().executeScript(initMap);
            //         mapView.getEngine().executeScript("initMap();");
                
            // });
            
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void switchToLoginScene(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/gui/LoginScene.fxml"));
            root = loader.load();
        
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            // String css = this.getClass().getResource("../view/gui/Gui_Interface.css").toExternalForm();
            
            // scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
            

        } catch(Exception e) {

        }
    }

    public void switchToMainScene(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/gui/MainScene.fxml"));
            root = loader.load();
        
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            // String css = this.getClass().getResource("../view/gui/Gui_Interface.css").toExternalForm();
            
            // scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
            

        } catch(Exception e) {

        }
    }
}

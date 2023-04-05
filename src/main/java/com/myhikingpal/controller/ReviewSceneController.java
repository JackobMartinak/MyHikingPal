package com.myhikingpal.controller;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;


public class ReviewSceneController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMapScene(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("../view/gui/MapScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void switchToMainScene(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("../view/gui/MainScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void switchToLoginScene(ActionEvent event) {
        try{
            root = FXMLLoader.load(getClass().getResource("../view/gui/LoginScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

package com.myhikingpal.controller;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;;

public class MainSceneController {
    @FXML
    Label welcomeLabel;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

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

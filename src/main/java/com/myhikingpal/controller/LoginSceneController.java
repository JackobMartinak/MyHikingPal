package com.myhikingpal.controller;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;

import com.myhikingpal.model.User;

public class LoginSceneController {

    @FXML
    TextField nameFieldLogin;
    TextField passFieldLogin;


    private Stage stage;
    private Scene scene;
    private Parent root;

    // private bool checkLogin(String username){
    //     String sql = "SELECT name FROM users WHERE name = ";
    // }

    @FXML
    public void login (ActionEvent event){
        try{
            String username = nameFieldLogin.getText();
            System.out.println(username);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/MainScene.fxml"));
            root = loader.load();
            
            
            MainSceneController sceneToLogin = loader.getController();
            sceneToLogin.displayName(username);

            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            String css = this.getClass().getResource("../gui/Gui_Interface.css").toExternalForm();
            
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            System.out.print(e);
        }
    }

    @FXML
    public void signup (ActionEvent event){
        try{
            // String username = nameFieldLogin.getText();
            // System.out.println(username);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/SignupScene.fxml"));
            root = loader.load();
            
            
            // MainSceneController sceneToLogin = loader.getController();
            // sceneToLogin.displayName(username);




            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            String css = this.getClass().getResource("../gui/Gui_Interface.css").toExternalForm();
            
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            System.out.print(e);
        }
    }
    
}

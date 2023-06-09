package com.myhikingpal.controller;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;


// import com.myhikingpal.model.User;
import com.myhikingpal.model.User;

public class LoginSceneController {

    @FXML
    TextField nameFieldLogin;
    @FXML
    PasswordField passFieldLogin;
    @FXML
    Label loginLabel;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private boolean checkLogin(){

        String username = nameFieldLogin.getText();
        String password = passFieldLogin.getText();
        final User customer = new User(username, password);
        if(customer.getUser(username)){
            return true;
        } else {
            return false;
        }

        
    }

    @FXML
    public void login (ActionEvent event){

        
        if(checkLogin()){
            try{
                String username = nameFieldLogin.getText();
               
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/gui/MainScene.fxml"));
                root = loader.load();
                
                MainSceneController sceneToLogin = loader.getController();
                sceneToLogin.displayName(username);
                // sceneToLogin.displayTime();
    
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                String css = this.getClass().getResource("../view/gui/LoginScene.css").toExternalForm();
                
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
    
            } catch(Exception e) {
                System.out.print(e);
            }
        } else {
            loginLabel.setText("Incorrect Credentials!");
        }
    }

    @FXML
    public void signup (ActionEvent event){
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/gui/SignupScene.fxml"));
            root = loader.load();
        
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            String css = this.getClass().getResource("../view/gui/Gui_Interface.css").toExternalForm();
            
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            System.out.print(e);
        }
    }
    
}

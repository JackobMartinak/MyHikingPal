package com.myhikingpal.controller;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myhikingpal.model.DbConnection;
import com.myhikingpal.model.User;


public class SignUpSceneController {

    @FXML
    TextField signUpUsername;
    @FXML
    PasswordField signUpPassword;
    @FXML
    PasswordField signUpConfPassword;
    @FXML
    Label signUpLabel;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private boolean signupCheck(){
        
        // String messLabel = signUpLabel.getText();


        String username = signUpUsername.getText();
        String password = signUpPassword.getText();
        String passwordConfirm = signUpConfPassword.getText();


        String sql = "SELECT * FROM users WHERE name = ?";
        try 
        {
            Connection conn = DbConnection.getInstance().getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql);

            pstmt.setString(1, username);
            ResultSet rs  = pstmt.executeQuery();
            if(rs.getString("name") == null && password.equals(passwordConfirm) && password.length() >= 6 && password.length() <= 12){
                registerToDB(username, password);
                return true;

            } else {
                signUpLabel.setText("Incorrect credetials => Password needs to be 6 - 12 characters long, and username needs to be unique");
                signUpLabel.setLayoutX(100);
                System.out.println("Username: " + username + "  Pass: " + password + "  PassConf: " + passwordConfirm);
            }
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        

        return false;


    }

    private void registerToDB(String username, String pass){

        final User customer = new User(username, pass);
        customer.CreateUser();

        
    }

    @FXML
    public void signup (ActionEvent event){

        if(signupCheck()){
            try{

                String username = signUpUsername.getText();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/gui/MainScene.fxml"));
                root = loader.load();
                
                MainSceneController sceneToLogin = loader.getController();
                sceneToLogin.displayName(username);
                // sceneToLogin.displayTime();
                
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

    @FXML
    public void goback(ActionEvent event){

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/gui/LoginScene.fxml"));
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

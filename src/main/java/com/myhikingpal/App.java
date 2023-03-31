package com.myhikingpal;
import java.util.concurrent.Flow;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

import com.myhikingpal.model.DbConnection;

/**
 * JavaFX App
 */
public class App extends Application {

   
    // private static Scene scene;

    @Override
    public void start(Stage mainWindow) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("./gui/LoginScene.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("/gui/LoginScene.fxml"));
            // Scene scene = new Scene(loadFXML("../../../resources/com/myhikingpal/gui/LoginScene.fxml"));
            Scene scene = new Scene(root);
            mainWindow.setTitle("MyHikingPal");

            mainWindow.setResizable(false);
            mainWindow.setScene(scene);
            mainWindow.show();
    }



    public static void main(String[] args) {
        try{
            DbConnection.getInstance().getConnection();
        } catch (Exception e ){
            System.out.println("Error in loading database!");
        }
        launch(args);
    }

}
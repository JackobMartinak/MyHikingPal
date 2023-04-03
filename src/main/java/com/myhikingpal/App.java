package com.myhikingpal;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

import com.myhikingpal.model.DbConnection;

/**
 * JavaFX App
 */
public class App extends Application {

    class WindowButtons extends HBox {

        public WindowButtons() {
            Button closeBtn = new Button("X");

            closeBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    Platform.exit();
                }
            });

            this.getChildren().add(closeBtn);
        }
    }

    // private static Scene scene;

    @Override
    public void start(Stage mainWindow) throws IOException {
            
            Parent root = FXMLLoader.load(getClass().getResource("./view/gui/LoginScene.fxml"));

            Scene scene = new Scene(root);


            mainWindow.setTitle("MyHikingPal");
            // mainWindow.initStyle(StageStyle.UNDECORATED);
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
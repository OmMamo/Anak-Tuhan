package com.example.anaktuhan;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 * gudbai dunia
 *
 */
public class App extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("table.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Waktu Suci");
        stage.setScene(scene);
        stage.show();
    }
    public static void main( String[] args )
    {
        launch(args);
    }
}

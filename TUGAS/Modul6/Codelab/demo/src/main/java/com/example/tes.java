package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tes extends Application {
    
    public void start (Stage stage){

        VBox root = new VBox();
        Scene scene = new Scene(root);
        stage.setTitle("Codelab Modul 6");
        stage.setScene(scene);
        stage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

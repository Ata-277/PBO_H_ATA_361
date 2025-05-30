package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Application {

    private int angkaRahasia;
    private int jumlahTebakan = 0;
    private final int MAX_TEBakan = 5;
    private final List<Integer> riwayat = new ArrayList<>();

    private Label labelFeedback;
    private Label labelJumlah;
    private Label labelRiwayat;
    private Button btnTebak;
    private TextField inputTebakan;

    private void generateAngkaBaru() {
        Random rand = new Random();
        angkaRahasia = rand.nextInt(100) + 1;
        jumlahTebakan = 0;
        riwayat.clear();
        labelFeedback.setText("");
        labelJumlah.setText("Jumlah percobaan: 0");
        labelRiwayat.setText("Riwayat tebakan: -");
        btnTebak.setText("🎯 Coba Tebak!");
        inputTebakan.clear();
        inputTebakan.setDisable(false);
    }

    private void showAlert(String pesan) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) {
        Label labelJudul = new Label("🎯 Tebak Angka 1–100");
        labelJudul.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #1a237e;");

        Label labelSub = new Label("Masukkan tebakanmu!");
        labelSub.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333;");

        inputTebakan = new TextField();
        inputTebakan.setPromptText("...");

        btnTebak = new Button("🎯 Coba Tebak!");
        btnTebak.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        labelFeedback = new Label();
        labelFeedback.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        labelJumlah = new Label("Jumlah percobaan: 0");
        labelJumlah.setStyle("-fx-font-size: 12px; -fx-text-fill: gray;");
        labelRiwayat = new Label("Riwayat tebakan: -");
        labelRiwayat.setStyle("-fx-font-size: 12px; -fx-text-fill: gray;");

        btnTebak.setOnAction(e -> {
            if (btnTebak.getText().equals("Main Lagi")) {
                generateAngkaBaru();
                return;
            }

            String input = inputTebakan.getText();
            try {
                int tebakan = Integer.parseInt(input);
                jumlahTebakan++;
                riwayat.add(tebakan);
                labelJumlah.setText("Jumlah percobaan: " + jumlahTebakan);
                labelRiwayat.setText("Riwayat tebakan: " + riwayat.toString());

                if (tebakan < angkaRahasia) {
                    labelFeedback.setText("Terlalu kecil!");
                } else if (tebakan > angkaRahasia) {
                    labelFeedback.setText("Terlalu besar!");
                } else {
                    labelFeedback.setText("Tebakan benar!");
                    showAlert("Selamat! Kamu berhasil menebak dengan benar 🎉");
                    inputTebakan.setDisable(true);
                    btnTebak.setText("Main Lagi");
                    return;
                }

                if (jumlahTebakan >= MAX_TEBakan) {
                    labelFeedback.setText("Kesempatan habis! Angka benar: " + angkaRahasia);
                    showAlert("Kesempatan habis! Jawaban yang benar adalah " + angkaRahasia);
                    inputTebakan.setDisable(true);
                    btnTebak.setText("Main Lagi");
                }

            } catch (NumberFormatException ex) {
                labelFeedback.setText("Masukkan angka yang valid!");
            }
        });

        VBox root = new VBox(8);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #e3f2fd;");

        HBox inputBox = new HBox(10, inputTebakan, btnTebak);
        inputBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(labelJudul, labelSub, inputBox, labelFeedback, labelJumlah, labelRiwayat);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 380, 240);
        primaryStage.setTitle("Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.show();

        generateAngkaBaru();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

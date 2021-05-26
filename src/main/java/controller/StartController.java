package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    private Button studentsView;

    @FXML
    private Button entrantView;

    @FXML
    private Button representView;

    @FXML
    private Button comissionView;

    @FXML
    private Button specializeView;

    /**
     * Метод, для открытия окна студентов
     */
    public void openStudentsView(){
        studentsView.setOnAction(event -> {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/studentsEditorView.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    });
}

    /**
     * Метод для открытия окна абитурентов
     */
    public void openEntratView(){
    entrantView.setOnAction(event -> {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/entrantView.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    });
}

    /**
     * Метод, для открытия окна представителей
     */
    public void openRepresentView(){
    representView.setOnAction(event -> {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resresateView.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    });
}

    /**
     * Метод, для открытия окна приемной комиссии
     */
    public void openComissionView(){
        comissionView.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/comissionView.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
    /**
     * Метод, для открытия окна специальностей
     */
    public void openSpecializeView(){
        specializeView.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/specializeView.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}



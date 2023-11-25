package com.uncw.expensetracker.driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginbutton;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void loginPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpenseTracker.fxml"));
            Parent root = loader.load();


            Stage expenseTrackerStage = new Stage();
            expenseTrackerStage.setTitle("Expense Tracker");
            expenseTrackerStage.setScene(new Scene(root));


            expenseTrackerStage.show();


            ((Stage) loginbutton.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
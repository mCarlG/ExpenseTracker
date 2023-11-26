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
    private Button loginButton;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void loginPressed(ActionEvent event) {
        try {
            if (username.getText().isBlank() || password.getText().isBlank()){
                throw new IllegalArgumentException();
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpenseTracker.fxml"));
            Parent root = loader.load();


            Stage expenseTrackerStage = new Stage();
            expenseTrackerStage.setTitle("Expense Tracker");
            expenseTrackerStage.setScene(new Scene(root));


            expenseTrackerStage.show();


            ((Stage) loginButton.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            username.setText("Enter Username");
            username.selectAll();
            username.requestFocus();
            password.setText("Enter Password");
            password.selectAll();
        }
    }

}
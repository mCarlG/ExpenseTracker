package com.uncw.expensetracker.driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpenseTrackerController {

    @FXML
    private Button addButton;

    @FXML
    private TextField amount;

    @FXML
    private ChoiceBox<?> amountCategoryDrop;

    @FXML
    private Button calcFinal;

    @FXML
    private TextField personal;

    @FXML
    private Slider personalSlider;

    @FXML
    private Slider savingSlider;

    @FXML
    private TextField savings;

    @FXML
    private Button setButton;

    @FXML
    private TextField total;

    @FXML
    private ChoiceBox<?> typeExpenseDrop;

    @FXML
    private TextField utilities;

    @FXML
    private Slider utilitiesSlider;

    @FXML
    void addExpensePressed(ActionEvent event) {

    }

    @FXML
    void calculatePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpenseDisplay.fxml"));
            Parent root = loader.load();

            ExpenseDisplayController displayController = loader.getController();
            displayController.setBudgetData(amount.getText(), personal.getText(), savings.getText(), utilities.getText());


            Stage expenseDisplayStage = new Stage();
            expenseDisplayStage.setTitle("Expense Display");
            expenseDisplayStage.setScene(new Scene(root));


            expenseDisplayStage.show();


            ((Stage) calcFinal.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setBudgetPressed(ActionEvent event) {

    }

}

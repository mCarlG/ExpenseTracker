package com.uncw.expensetracker.driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class ExpenseTrackerController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private TextField amount;

    @FXML
    private ChoiceBox<String> amountCategoryDrop;

    @FXML
    private Button calcFinal;

    @FXML
    private TextField personal;

    @FXML
    private TextField personalTextField;

    @FXML
    private TextField savingsTextField;

    @FXML
    private TextField savings;

    @FXML
    private Button setButton;

    @FXML
    private TextField total;

    @FXML
    private ChoiceBox<String> typeExpenseDrop;

    private final String[] expenses = {"Utilities", "Personal", "Savings"};

    @FXML
    private TextField utilitiesTextField;

    private BigDecimal utilitiesamt = new BigDecimal(0);
    private BigDecimal savingsamt = new BigDecimal(0);
    private BigDecimal personalamt = new BigDecimal(0);
    private BigDecimal budget = new BigDecimal(0);
    private BigDecimal utilitiesBudget = new BigDecimal(0);
    private BigDecimal personalBudget = new BigDecimal(0);
    private BigDecimal savingsBudget = new BigDecimal(0);

    @FXML
    private TextField utilities;

    @FXML
    void addExpensePressed(ActionEvent event) {
        try{
            BigDecimal total = new BigDecimal(this.total.getText());
            if (typeExpenseDrop.getValue() == null){throw new NumberFormatException();}
            if (typeExpenseDrop.getValue().equals("Utilities")){
                utilitiesamt = utilitiesamt.add(total);
            }
            else if (typeExpenseDrop.getValue().equals("Savings")){
                savingsamt = savingsamt.add((total));
            }
            else{
                personalamt = personalamt.add(total);
            }
            utilities.setText(String.valueOf(utilitiesamt));
            savings.setText(String.valueOf(savingsamt));
            personal.setText(String.valueOf(personalamt));
        }
        catch (NumberFormatException e){
            total.setText("Enter amount");
            total.selectAll();
            total.requestFocus();
        }
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
        try{
            BigDecimal amount = new BigDecimal(this.amount.getText());
            if (amountCategoryDrop.getValue() == null){throw new NumberFormatException();}
            budget = budget.add(amount);
            if (amountCategoryDrop.getValue().equals("Utilities")){
                utilitiesBudget = utilitiesBudget.add(amount);
            }
            else if (amountCategoryDrop.getValue().equals("Personal")){
                personalBudget = personalBudget.add(amount);
            }
            else{
                savingsBudget = savingsBudget.add(amount);
            }
            double budgetD = Double.valueOf(String.valueOf(budget));
            utilitiesTextField.setText(String.format("%.2f", 100.0*(Double.parseDouble(String.valueOf(utilitiesBudget))/budgetD)));
            personalTextField.setText(String.format("%.2f", 100.0*(Double.parseDouble(String.valueOf(personalBudget))/budgetD)));
            savingsTextField.setText(String.format("%.2f", 100.0*(Double.parseDouble(String.valueOf(savingsBudget))/budgetD)));
        }
        catch (NumberFormatException e){
            amount.setText("Enter amount");
            amount.selectAll();
            amount.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeExpenseDrop.getItems().addAll(expenses);
        amountCategoryDrop.getItems().addAll(expenses);
    }
}

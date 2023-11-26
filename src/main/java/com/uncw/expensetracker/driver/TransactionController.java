package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import com.uncw.expensetracker.records.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TransactionController {
    @FXML
    private TextField description;
    @FXML
    private TextField amount;
    @FXML
    private ComboBox<String> type;
    @FXML
    private DatePicker date;


    private Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML void addTransaction() {
        this.account.addTransaction(
                new Transaction(
                        type.getTypeSelector(),
                        date.getValue(),
                        Float.parseFloat(amount.getText()),
                        description.getText()
                ));
    }
}

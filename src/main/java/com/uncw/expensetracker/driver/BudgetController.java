package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Objects;

public class BudgetController {
    @FXML
    TextField amount;
    @FXML
    ComboBox<String> type;
    private Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    public void updateBudgetPressed() {
        String budgetType = type.getValue();
        float budgetAmount = Float.parseFloat(amount.getText());
        if (budgetType.equals("Bills")) {
            account.setBillsBudget(budgetAmount);
        } else if (budgetType.equals("Personal Expense")) {
            account.setPersonalBudget(budgetAmount);
        } else if (budgetType.equals("Savings")) {
            account.setSavingsBudget(budgetAmount);
        }
    }
}

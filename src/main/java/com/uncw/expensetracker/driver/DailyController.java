package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import com.uncw.expensetracker.records.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.List;

public class DailyController {
    @FXML
    DatePicker date;
    @FXML
    TextField billsActual;
    @FXML
    TextField billsBudget;
    @FXML
    TextField billsPercent;
    @FXML
    TextField personalActual;
    @FXML
    TextField personalBudget;
    @FXML
    TextField personalPercent;
    @FXML
    TextField savingsActual;
    @FXML
    TextField savingsBudget;
    @FXML
    TextField savingsPercent;
    private Account account;
    private float totalBillExpense;
    private float totalPersonalExpense;
    private float totalDeposit;

    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    public void loadDay() {
        billsBudget.setText("$" + account.getBillsBudget());
        savingsBudget.setText("$" + account.getSavingsBudget());
        personalBudget.setText("$" + account.getPersonalBudget());

        if (date.getValue() == null) {return;}
        List< Transaction > transactions = account.getTransactionsForDay(date.getValue());

        if (transactions == null) {return;}

        for (Transaction transaction : transactions) {
            switch (transaction.getType()) {
                case "Bills" -> totalBillExpense += transaction.getAmount();
                case "Personal Expense" -> totalPersonalExpense += transaction.getAmount();
                case "Deposit" -> totalDeposit += transaction.getAmount();
            }
        }

        float totalSavings = totalDeposit - (totalBillExpense + totalPersonalExpense);
        billsActual.setText("$" + totalBillExpense);
        personalActual.setText("$" + totalPersonalExpense);
        savingsActual.setText("$" + totalSavings);

        billsPercent.setText(String.format("%.2f",(totalBillExpense / account.getBillsBudget()) * 100));
        savingsPercent.setText(String.format("%.2f",(totalSavings / account.getSavingsBudget()) * 100));
        personalPercent.setText(String.format("%.2f",(totalPersonalExpense / account.getPersonalBudget()) * 100));
    }
}

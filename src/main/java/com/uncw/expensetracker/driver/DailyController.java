package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import com.uncw.expensetracker.records.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import java.util.List;

public class DailyController {
    @FXML
    DatePicker date;
    private Account account;
    private float totalBillExpense;
    private float totalPersonalExpense;
    private float totalDeposit;
    private float totalSavings;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    public void loadDay() {
        List< Transaction > transactions = account.getTransactionsForDay(date.getValue());
    }
}

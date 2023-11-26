package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import com.uncw.expensetracker.records.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.YearMonth;
import java.util.List;

public class MonthlyController {
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
    public void loadMonth() {
        if (date.getValue() == null) {return;}
        YearMonth yearMonth = YearMonth.of(date.getValue().getYear(), date.getValue().getMonthValue());
        float monthlyBillsBudget = account.getBillsBudget() * yearMonth.lengthOfMonth();
        float monthlySavingsBudget = account.getSavingsBudget() * yearMonth.lengthOfMonth();
        float monthlyPersonalBudget = account.getPersonalBudget() * yearMonth.lengthOfMonth();
        billsBudget.setText("$" + monthlyBillsBudget);
        savingsBudget.setText("$" + monthlySavingsBudget);
        personalBudget.setText("$" + monthlyPersonalBudget);

        List<Transaction> transactions = account.getTransactionsForMonth(date.getValue());

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

        billsPercent.setText(String.format("%.2f",(totalBillExpense / monthlyBillsBudget) * 100));
        savingsPercent.setText(String.format("%.2f",(totalSavings / monthlySavingsBudget) * 100));
        personalPercent.setText(String.format("%.2f",(totalPersonalExpense / monthlyPersonalBudget) * 100));
    }
}

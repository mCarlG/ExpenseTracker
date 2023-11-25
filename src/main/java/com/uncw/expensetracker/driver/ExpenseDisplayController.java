package com.uncw.expensetracker.driver;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;

public class ExpenseDisplayController {

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private TextField budgetDisp;

    @FXML
    private TextField leftOverDisp;

    @FXML
    private PieChart pieDisp;

    @FXML
    private TextField totalPersonalDisp;

    @FXML
    private TextField totalSavingsDisp;

    @FXML
    private TextField totalUtilityDisp;

    public void setBudgetData(String amount, String personal, String savings, String utilities) {
        budgetDisp.setText(amount);
        totalPersonalDisp.setText(personal);
        totalSavingsDisp.setText(savings);
        totalUtilityDisp.setText(utilities);
    }

}

package com.uncw.expensetracker.records;

public class Expense {
    private float totalExpense;

    public Expense (float totalExpense) {
        this.totalExpense = totalExpense;
    }

    public void setTotalExpense(float totalExpense) {
        this.totalExpense = totalExpense;
    }

    public float getTotalExpense(){
        return this.totalExpense;
    }
}
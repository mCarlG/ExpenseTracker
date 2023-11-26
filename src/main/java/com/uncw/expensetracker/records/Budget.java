package com.uncw.expensetracker.records;

public class Budget {
    private float totalBudget;

    public Budget(float totalBudget) {
        this.totalBudget = totalBudget;
    }

    public void setTotalBudget(float totalBudget) {
        this.totalBudget = totalBudget;
    }

    public float getTotalBudget() {
        return this.totalBudget;
    }

    public float addToBudget(float amountToAdd) {
        return this.totalBudget + amountToAdd;
    }
}
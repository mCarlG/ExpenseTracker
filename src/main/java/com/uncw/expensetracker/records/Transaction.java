package com.uncw.expensetracker.records;
import java.time.LocalDate;

public class Transaction {
    private String type;
    private LocalDate date;
    private double amount;
    private String description;

    public Transaction(String type, LocalDate date, double amount, String description) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }
}

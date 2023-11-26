package com.uncw.expensetracker.records;
import java.time.LocalDate;

public class Transaction {
    private String type;
    private final LocalDate date;
    private final float amount;
    private String description;

    public Transaction(String type, LocalDate date, float amount, String description) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public float getAmount() {
        return this.amount;
    }

    public String getType() {
        return type;
    }
}

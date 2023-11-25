module com.uncw.expensetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.uncw.expensetracker.records;
    exports com.uncw.expensetracker.driver;
}
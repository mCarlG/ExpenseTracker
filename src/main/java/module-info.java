module com.uncw.expensetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.uncw.expensetracker.driver to javafx.fxml;
    opens com.uncw.expensetracker.records to javafx.fxml,com.google.gson;

    exports com.uncw.expensetracker.records;
    exports com.uncw.expensetracker.driver;
}
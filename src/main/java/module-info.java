module com.uncw.expensetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.uncw.expensetracker to javafx.fxml;
    exports com.uncw.expensetracker.records;
    exports com.uncw.expensetracker.driver;
    opens com.uncw.expensetracker.driver to javafx.fxml;
}
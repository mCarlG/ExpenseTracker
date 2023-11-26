package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    private BorderPane root;
    private Account loadedAccount = new Account();

    @FXML
    private Menu accountMenu;
    @FXML
    private Menu transactionMenu;
    @FXML
    private Menu budgetMenu;
    @FXML
    private Menu dailyMenu;
    @FXML
    private Menu monthlyMenu;


    public void initialize() {
        accountMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                try {
                    accountPressed();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                accountMenu.hide();
            }
        });

        transactionMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                try {
                    transactionPressed();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                transactionMenu.hide();
            }
        });

        budgetMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                try {
                    budgetPressed();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                budgetMenu.hide();
            }
        });

        dailyMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                try {
                    dailyPressed();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dailyMenu.hide();
            }
        });

        monthlyMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                try {
                    monthlyPressed();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                monthlyMenu.hide();
            }
        });
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
    @FXML
    void accountPressed() throws IOException {
        FXMLLoader accountLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/Account.fxml")));
        VBox subRoot = accountLoader.load();
        AccountController accountController = accountLoader.getController();
        accountController.setAccount(loadedAccount);
        root.setCenter(subRoot);
    }
    @FXML
    void transactionPressed() throws IOException {
        FXMLLoader transactionLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/Transaction.fxml")));
        GridPane subRoot = transactionLoader.load();
        TransactionController transactionController = transactionLoader.getController();
        transactionController.setAccount(loadedAccount);
        root.setCenter(subRoot);
    }
    @FXML
    void budgetPressed() throws IOException {
        FXMLLoader budgetLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/Budget.fxml")));
        GridPane subRoot = budgetLoader.load();
        BudgetController budgetController = budgetLoader.getController();
        budgetController.setAccount(loadedAccount);
        root.setCenter(subRoot);
    }
    @FXML
    void dailyPressed() throws IOException {
        FXMLLoader dailyLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/Daily.fxml")));
        GridPane subRoot = dailyLoader.load();
        DailyController dailyController = dailyLoader.getController();
        dailyController.setAccount(loadedAccount);
        root.setCenter(subRoot);
    }
    @FXML
    void monthlyPressed() throws IOException {
        FXMLLoader monthlyLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/Monthly.fxml")));
        GridPane subRoot = monthlyLoader.load();
        MonthlyController monthlyController = monthlyLoader.getController();
        monthlyController.setAccount(loadedAccount);
        root.setCenter(subRoot);
    }

}

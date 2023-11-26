package com.uncw.expensetracker.driver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    private BorderPane root;

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

    public void setMainLayout(BorderPane root) {
        this.root = root;
    }
    @FXML
    void accountPressed() throws IOException {
        root.setCenter(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Account.fxml"))));
    }
    @FXML
    void transactionPressed() throws IOException {
        root.setCenter(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Transaction.fxml"))));
    }
    @FXML
    void budgetPressed() throws IOException {
        root.setCenter(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Budget.fxml"))));
    }
    @FXML
    void dailyPressed() throws IOException {
        root.setCenter(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Daily.fxml"))));
    }
    @FXML
    void monthlyPressed() throws IOException {
        root.setCenter(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Monthly.fxml"))));
    }

}

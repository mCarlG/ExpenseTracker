package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class AccountController {
    @FXML
    private Button loadAccount;
    @FXML
    private Button saveAccount;
    private Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    void loadAccountPressed() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            this.account = new Account(selectedFile);
        }
    }
    @FXML
    void saveAccountPressed() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            this.account.saveToJsonFile(selectedFile);
        }
    }
    @FXML
    void newAccountPressed() {
        this.account = new Account();
    }
}

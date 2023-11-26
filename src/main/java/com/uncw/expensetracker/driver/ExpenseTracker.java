package com.uncw.expensetracker.driver;

import com.uncw.expensetracker.records.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

//driver
public class ExpenseTracker extends Application{
    private BorderPane root;
    private Account loadedAccount;

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/Root.fxml")));
        root = loader.load();
        MenuController menuController = loader.getController();
        menuController.setMainLayout(root);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(Objects.requireNonNull(getClass().getResource("/css/primary.css"))));
        stage.setTitle("ExpenseTracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
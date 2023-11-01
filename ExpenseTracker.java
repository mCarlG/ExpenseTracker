import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import records.*;

public class ExpenseTracker extends Application {
        @Override
        public void start(Stage primaryStage) {
            Daily test = new Daily();
            GridPane root = new GridPane();
            root.setAlignment(Pos.CENTER);
            root.setHgap(10);
            root.setVgap(10);

            TextField writeTextField = new TextField();
            TextField readTextField = new TextField();
            readTextField.setEditable(false);
            Button writeDaily = new Button();
            writeDaily.setText("Set daily string");
            Button readDaily = new Button();
            readDaily.setText("Read daily string");
            final Text actionTarget = new Text();
            writeDaily.setOnAction(actionEvent -> {
                actionTarget.setFill(Color.ANTIQUEWHITE);
                actionTarget.setText("Copied text to daily object.");
                test.records = writeTextField.getText();
            });

            readDaily.setOnAction(actionEvent ->  {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Copied text from daily object.");
                    readTextField.setText(test.records);
            });

            root.add(writeDaily, 0, 1);
            root.add(writeTextField, 1, 1);
            root.add(readDaily, 0, 2);
            root.add(readTextField, 1, 2);
            root.add(actionTarget, 1, 6);

            Scene scene = new Scene(root, 300, 250);

            primaryStage.setTitle("Hello, World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
}

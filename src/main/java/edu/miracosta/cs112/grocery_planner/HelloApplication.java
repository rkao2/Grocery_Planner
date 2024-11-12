package edu.miracosta.cs112.grocery_planner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

//testing3
public class HelloApplication extends Application {

    private Button addItemButton;
    private Button displayGroceriesButton;
    private Button balanceButton;
    private Label titleLabel;

    @Override
    public void start(Stage stage) throws IOException {

        titleLabel = new Label("Grocery Planner");
        titleLabel.setFont(new javafx.scene.text.Font("Arial", 20));
        titleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);


        addItemButton = new Button("Add Item");
        displayGroceriesButton = new Button("Display Groceries");
        balanceButton = new Button("Balance");


        addItemButton.setOnAction(e -> {
            // Code to execute when "Add Item" button is clicked
            System.out.println("Add Item button clicked!");
        });

        displayGroceriesButton.setOnAction(e -> {
            // Code to display groceries
            System.out.println("Display Groceries button clicked!");
        });

        balanceButton.setOnAction(e -> {
            // Code to show balance
            System.out.println("Balance button clicked!");
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, addItemButton, displayGroceriesButton, balanceButton);

        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Grocery Planner");
        stage.setScene(scene);
        stage.show();
    }





    public static void main(String[] args) {
        launch();

    }
}
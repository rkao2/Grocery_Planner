package edu.miracosta.cs112.grocery_planner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    private Stage primaryStage; // Main stage to switch scenes
    private List<String> groceries = new ArrayList<>(); // Backend list to store grocery items
    private double balance = 100.0; // Example balance

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        // Load the initial home page
        showHomePage();

        stage.setTitle("Grocery Planner");
        stage.show();
    }

    /**
     * Home Page Scene
     */
    private void showHomePage() {
        Label titleLabel = new Label("Grocery Planner");
        titleLabel.setFont(new javafx.scene.text.Font("Arial", 20));
        titleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Button addItemButton = new Button("Add Item");
        Button displayGroceriesButton = new Button("Display Groceries");
        Button balanceButton = new Button("Balance");

        addItemButton.setOnAction(e -> showAddItemPage());
        displayGroceriesButton.setOnAction(e -> showDisplayGroceriesPage());
        balanceButton.setOnAction(e -> showBalancePage());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, addItemButton, displayGroceriesButton, balanceButton);

        Scene scene = new Scene(layout, 320, 240);
        primaryStage.setScene(scene);
    }

    /**
     * Add Item Scene
     */
    private void showAddItemPage() {
        Label instructionLabel = new Label("Enter the item and price:");
        TextField itemField = new TextField();
        itemField.setPromptText("Item name");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        Button addButton = new Button("Add");
        Button backButton = new Button("Back");

        addButton.setOnAction(e -> {
            String item = itemField.getText();
            String priceText = priceField.getText();
            if (item.isEmpty() || priceText.isEmpty()) {
                showAlert("Error", "Both fields are required!", Alert.AlertType.ERROR);
                return;
            }
            try {
                double price = Double.parseDouble(priceText);
                groceries.add(item + " - $" + price);
                balance -= price;
                showAlert("Success", "Item added successfully!", Alert.AlertType.INFORMATION);
                itemField.clear();
                priceField.clear();
            } catch (NumberFormatException ex) {
                showAlert("Error", "Price must be a valid number!", Alert.AlertType.ERROR);
            }
        });

        backButton.setOnAction(e -> showHomePage());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(instructionLabel, itemField, priceField, addButton, backButton);

        Scene scene = new Scene(layout, 320, 240);
        primaryStage.setScene(scene);
    }

    /**
     * Display Groceries Scene
     */
    private void showDisplayGroceriesPage() {
        Label titleLabel = new Label("Grocery List:");
        ListView<String> groceryList = new ListView<>();
        groceryList.getItems().addAll(groceries);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showHomePage());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, groceryList, backButton);

        Scene scene = new Scene(layout, 320, 240);
        primaryStage.setScene(scene);
    }

    /**
     * Balance Scene
     */
    private void showBalancePage() {
        Label balanceLabel = new Label(String.format("Current Balance: $%.2f", balance));

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showHomePage());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(balanceLabel, backButton);

        Scene scene = new Scene(layout, 320, 240);
        primaryStage.setScene(scene);
    }

    /**
     * Helper method to display alerts
     */
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}

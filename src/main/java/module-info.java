module edu.miracosta.cs112.grocery_planner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.miracosta.cs112.grocery_planner to javafx.fxml;
    exports edu.miracosta.cs112.grocery_planner;
}
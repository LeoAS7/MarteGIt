package com.example.todoapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private ObservableList<String> tasks;
    private ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List");

        // Create a list to store tasks
        tasks = FXCollections.observableArrayList();

        // Create UI components
        listView = new ListView<>(tasks);
        TextField taskField = new TextField();
        Button addButton = new Button("Add Task");
        Button deleteButton = new Button("Delete Task");

        // Add task to the list
        addButton.setOnAction(event -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskField.clear();
            }
        });

        // Delete selected task from the list
        deleteButton.setOnAction(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
            }
        });

        // Create a vertical layout and add components
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(listView, taskField, addButton, deleteButton);

        // Create the scene and set it on the stage
        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

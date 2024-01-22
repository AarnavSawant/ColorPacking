package com.example.colorpackingapplication;

import com.example.colorpackingapplication.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ColorPackingApplication extends Application {

    private int numRows = 1;
    private int numCols = 15;
    private int[][] grid = grid = new int[numRows][numCols]; // The 2D array to represent the grid
    private GridPane gridPane = new GridPane();

    private static HashMap<Integer, Color> intToColorMap = new HashMap<>();

    static {
        intToColorMap.put(1, Color.AQUAMARINE);
        intToColorMap.put(2, Color.ORANGE);
        intToColorMap.put(3, Color.VIOLET);
        intToColorMap.put(4, Color.TOMATO);
        intToColorMap.put(5, Color.TAN);
        intToColorMap.put(6, Color.CORAL);
        intToColorMap.put(7, Color.CORNSILK);
        intToColorMap.put(8, Color.SKYBLUE);
        intToColorMap.put(9, Color.BLUEVIOLET);
        intToColorMap.put(10, Color.CRIMSON);
        intToColorMap.put(11, Color.CYAN);
        intToColorMap.put(12, Color.SPRINGGREEN);
        intToColorMap.put(13, Color.STEELBLUE);
        intToColorMap.put(14, Color.MISTYROSE);
        intToColorMap.put(15, Color.INDIGO);

    }

    @Override
    public void start(Stage primaryStage) {
        initializeGrid(); // Initialize the grid with values (e.g., 0 or 1)
        gridPane.setAlignment(Pos.CENTER);
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle cell = new Rectangle(50, 50); // Change the dimensions as needed
                cell.setFill(intToColorMap.get(grid[row][col])); // Customize the colors
                Text text = new Text("" + grid[row][col]); // Text content
                text.setTextOrigin(VPos.CENTER);
                text.setTextAlignment(TextAlignment.CENTER);
                GridPane.setRowIndex(text, row);
                GridPane.setColumnIndex(text, col);
                gridPane.add(cell, col, row);
                gridPane.add(text, col, row);
                GridPane.setHalignment(text, HPos.CENTER);
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Grid Array Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Initialize the grid with sample values (you can replace this with your own data)
    private void initializeGrid() {
        Backtracker.solveBoard(numRows, numCols);
        grid = Backtracker.getSolvedGrid().getRawBoard();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

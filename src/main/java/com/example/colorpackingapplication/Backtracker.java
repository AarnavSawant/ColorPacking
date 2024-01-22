package com.example.colorpackingapplication;

public class Backtracker {
    private static Board solvedGrid;
    private static final int MAXIMUM_NUMBER = 14;
    public static boolean solveBoard(int rows, int columns) {
        solvedGrid = new Board(new int[rows][columns]);
        return solveBoard(solvedGrid, 0, 0);
    }

    private static boolean solveBoard(Board b, int row, int column) {
        //Check if we've reached the end of the row and move to the next row
        if (column == b.getNumCols(row)) {
            column = 0;
            row++;
            //If we're on the last row and last column, we're done!
            if (row == b.getNumRows()) {
                return true;
            }
        }
        //Iterate throughout from 1 to 15 and try placing the piece in the current row and column
        for (int i = 1; i < MAXIMUM_NUMBER; i++) {
            //If our board meets all constraints
            if (isValid(solvedGrid, row, column, i)) {
                //insert it and create a new state
                solvedGrid.insert(row, column, i);
                //Now move to next cell and try inserting values
                if (solveBoard(solvedGrid, row, column + 1)) {
                    return true;
                }
            }
            //If this we're "resetting", set this current cell back to zero and keep looping!
            solvedGrid.insert(row, column, 0);
        }
        return false;
    }


    public static boolean isValid(Board board, int row, int column, int val) {
        board.insert(row, column, val);
        return board.isValid();
    }

    public static Board getSolvedGrid() {return solvedGrid;};

    public static String getSolvedGridString() {
        return solvedGrid.toString();
    }
}

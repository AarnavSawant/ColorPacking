package com.example.colorpackingapplication;

import java.util.Arrays;

public class Board {
    private int[][] board;

    public Board(int length, int width) {
        board = new int[length][width];
    }

    public Board(int[][] board) {
        this.board = board;
    }

    public boolean isValid() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
//                System.out.println(board[i][j]);
                if (!checkColorPacking(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void insert(int row, int column, int val) {
        board[row][column] = val;
    }

    public int getNumRows() {
        return board.length;
    }

    public int getNumCols(int row) {
        return board[row].length;
    }

    public int[][] getRawBoard() {
        return board;
    }

    private boolean checkColorPacking(int[][] grid, int row, int column) {
        //Set the radius to the value of the current cell
        int radius = grid[row][column];
        //Check all cells in a radius x radius square around the current cell
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                //Make sure the row/column we're iterating over is within the range of the board
                if (row + i >= 0 && row + i < grid.length && column + j >= 0 &&
                        column + j < grid[row + i].length) {
                    int magnitude = i * i + j * j;
                    //We only want cells within a circle of the given radius, so check the distance between
                    //current coordinate and the coordinate of the cell we're iterating over
                    if (magnitude != 0 && magnitude <= radius * radius) {
                        //Make sure there are no cells with the same value
                        // in our circle of the given radius
                        if (grid[row + i][column + j] == radius) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(board);
    }


}

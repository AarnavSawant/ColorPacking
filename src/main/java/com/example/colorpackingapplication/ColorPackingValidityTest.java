package com.example.colorpackingapplication;

public class ColorPackingValidityTest {
    public static void main(String[] args) {
        System.out.println(Backtracker.solveBoard(10, 10));
        System.out.println(Backtracker.getSolvedGridString());
        System.out.println(Backtracker.isValid(new Board(new int[][]{{1, 0}, {1, 0}}), 1, 0, 1));
        Board b = new Board(new int[][]{{1, 2, 1, 3, 1, 1, 1, 1, 1, 1}});
        System.out.println(b.isValid());
    }
}

package ru.skopin.sudoku.main;

import static ru.skopin.sudoku.main.GameField.*;

public class Main {
    public static void main(String[] args) {
        printGameField();
        newPrintGameField();
        GraphicGameField graphicGameField = new GraphicGameField();
    }
}

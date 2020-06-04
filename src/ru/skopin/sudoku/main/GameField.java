package ru.skopin.sudoku.main;

public final class GameField {

    private final static int SIDE = 9;
    private static int[][] field;

    public static void printGameField () {
        for (int [] a : getField()) {
            for (int b : a) {
                System.out.print(b + "  ");
            }
            System.out.println("");
        }
    }
/*
    NEW type of printing GameField
 */
    public static void newPrintGameField () {
        for(int i = 0; i < field.length; i++) {
            for(int ii = 0; ii < field.length; ii++) {
                String line = " ";
                if (ii == 2 || ii == 5 ) {
                    line = " | ";
                }
                System.out.print(field[i][ii] + line);
            }
            System.out.println("");
            if (i == 2 || i == 5 ) {
                System.out.println("------+-------+------");
            }
        }
    }
/*
    make field put in all array 12...89
    random shifts in horizontal lines (to 1, 2, 3)
    and change vertical and horizontal lines in
    every 1/3 parts of array
 */
    private static int [][] makeSimpleField() {
        int [][] field = new int [SIDE][SIDE];
/*
    put in all array 12...89
 */

        for (int i = 0; i < SIDE; i++){
            for (int ii = 0; ii < SIDE; ii++) {
                field[i][ii] = ii + 1;
            }
        }
/*
    shift all array to 3 in horizontal
 */
        for (int i = 1; i < field.length; i++) {
            int ii = 3 * i;
            leftShift(field[i], ii);
        }
        int first = (int) (Math.random() * 3);
        int second = (int) (Math.random() * 3);
        while (first == second){
            second = (int) (Math.random() * 3);
        }
/*
     random shift one part of array
     upper 1/3 or middle 1/3 or lower 1/3
     to 2 in horizontal
     && one
     to 1 in horizontal
 */
        for (int i = 0; i < 3; i++) {
            int count = (int)(Math.random() * 2 + 1);
            leftShift(field[i + 3 * first], count);
            if(count == 1) {
                count = 2;
            } else {
                count = 1;
            }
            leftShift(field[i + 3 * second], count);
        }
        changeInHorizontal(field);
        changeInVertical(field);
        return field;
    }

/*
    random change two horizontal in every part of array
    upper 1/3 or middle 1/3 or lower 1/3
 */

    private static void changeInHorizontal(int[][] array) {
        int [] tempArray = new int [array.length];
        for (int i = 0; i < 3; i++) {
            int first = (int) (Math.random() * 3) + i * 3;
            int second = (int) (Math.random() * 3) + i * 3;
            while (first == second){
                second = (int) (Math.random() * 3) + i * 3;
            }
            tempArray = array[first];
            array[first] = array[second];
            array[second] = tempArray;
        }
    }

/*
    random change two vertical in every part of array
    upper 1/3 or middle 1/3 or lower 1/3
*/

    private static void changeInVertical(int[][] array) {
        int temp;
        for (int i = 0; i < 3; i++) {
            int first = (int) (Math.random() * 3) + i * 3;
            int second = (int) (Math.random() * 3) + i * 3;
            while (first == second){
                second = (int) (Math.random() * 3) + i * 3;
            }
            for(int ii = 0; ii < array.length; ii++){
                temp = array[ii][first];
                array[ii][first] = array[ii][second];
                array[ii][second] = temp;
            }
        }
    }

/*
    left shift in array
 */
    private static void leftShift(int[] array, int count) {
        for (int i = 0; i < count; i++) {
            int buffer = array[array.length - 1];
            array[array.length - 1] = array[0];
            for (int ii = 1; ii < (array.length - 1); ii++) {
                array[ii - 1] = array[ii];
            }
            array[array.length - 2] = buffer;
        }
    }

    public static int getSIDE() {
        return SIDE;
    }

    public static int[][] getField() {
        field = makeSimpleField();
        return field;
    }
}

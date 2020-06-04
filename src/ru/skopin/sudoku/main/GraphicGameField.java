package ru.skopin.sudoku.main;
import javax.swing.*;
import java.awt.*;
public class GraphicGameField extends JFrame {

    public static JButton[] jbs;

    public GraphicGameField() {

        int numberOfCells = GameField.getSIDE() * (GameField.getSIDE() + 1);
        setBounds(150,150,500,500);
        setResizable(false);
        setTitle("SuDoKu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



/*
        Заполнение поля кнопками с цифрой
*/
        jbs = new JButton[numberOfCells];
        setLayout(new GridLayout(GameField.getSIDE(), GameField.getSIDE()));

        for(int[] a : GameField.getField()) {
            int count = 0;
            for(int b : a) {
                jbs[count] = new JButton( "" + b);
                add(jbs[count]);
                count++;
            }
        }
        setVisible(true);
    }



}

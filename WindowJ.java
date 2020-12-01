package ru.lesson8;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WindowJ extends JFrame {
    public static int I;
    public static int COUNT;
    public static String ANSWER = new String("");
    public static String USER_ANSWER = new String("");
    public static String[][] PUZZLES = {{"В Полотняной стране\nПо реке Простыне\nПлывет пароход\nТо назад, то вперед,\nА за ним такая гладь —\nНи морщинки не видать.\n\n", "утюг"},
            {"В брюшке — баня,\nВ носу — решето,\nНос — хоботок,\nНа голове — пупок,\nВсего одна рука\nБез пальчиков,\nИ та — на спине\nКалачиком.\n\n", "чайник"},
            {"Стоит дуб,\nВ нем двенадцать гнезд,\nВ каждом гнезде\nПо четыре яйца,\nВ каждом яйце\nПо семи цыпленков.\n\n", "год"},
            {"Вдруг из черной темноты\nВ небе выросли кусты.\nА на них-то голубые,\nПунцовые, золотые\nРаспускаются цветы\nНебывалой красоты.\nИ все улицы под ними\nТоже стали голубыми,\nПунцовыми, золотыми,\nРазноцветными.\n\n", "салют"}};

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Загадки");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(300, 100, 400, 500);
        jFrame.setResizable(false);

        JTextArea jTextArea = new JTextArea("Отгадайте загадку:\n" + PUZZLES[I][0]);
        jTextArea.setBackground(Color.lightGray);
        jTextArea.setLineWrap(true);
        jTextArea.setLayout(null);
        jFrame.add(jTextArea, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JTextField jTextField = new JTextField();
        panel.setLayout(new GridLayout(1, 3));
        jTextField.setSize(20, 20);
        jTextField.setBackground(Color.pink);
        panel.add(jTextField, BorderLayout.PAGE_START);
        JButton answertButton = new JButton("Ответить");
        panel.add(answertButton, BorderLayout.CENTER);
        answertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    USER_ANSWER = jTextField.getText();
                    ANSWER = PUZZLES[I][1];
                    if (USER_ANSWER.equalsIgnoreCase(ANSWER)) {
                        jTextArea.append("Ответ " + jTextField.getText() + " верен.\n\n");
                        COUNT++;
                    } else {
                        jTextArea.append("Ответ " + jTextField.getText() + " не верен.\n\n");
                    }
                }
            });
        JButton nextButton = new JButton("Следующая");
        panel.add(nextButton, BorderLayout.PAGE_END);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if ((I + 1) < PUZZLES.length) {
                    I++;
                    jTextArea.append("Следующая загадка:\n" + PUZZLES[I][0]);
                } else {
                    jTextArea.append("Загадки закончились!");
                }
            }
        });
        jFrame.add(panel, BorderLayout.SOUTH);
        JScrollPane scrollBar=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jFrame.add(scrollBar);
        jFrame.setVisible(true);
    }
}


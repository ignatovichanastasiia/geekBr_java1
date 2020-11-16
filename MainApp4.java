package ru.lesson4;

import java.util.Random;
import java.util.Scanner;

public class MainApp4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final char[][] BOARD = new char[SIZE][SIZE];
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'x';
    public static final char DOT_O = 'o';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) break;
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) break;
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        System.out.println("The end!");
    }

    private static boolean win3(int xI, int xJ, int arI, int arJ, char s) {
        char[] winNorm = new char[]{s, s, s, s};
        char[] result = new char[]{s, s, s, s};
        int i = 0, j = 0;
        int count = 0;
        for (i = xI, j = xJ; i < arI; i++, j--) {
            result[count] = map[i][j];
            count++;
        }
        if (result == winNorm) {
            ;
            switch (s) {
                case 'x':
                    System.out.println("Gamer! You win!");
                    return true;
                case 'o':
                    System.out.println("Game over!");
                    return true;
            }
        }
        return false;
    }

    private static boolean win2(int xI, int xJ, int arI, int arJ, char s, int x1, int j1) {
        char[] result = new char[]{s, s, s, s};
        char[] winNorm = new char[]{s, s, s, s};
        int i = 0, j = 0;
        int count = 0;
        for (i = xI; i < arI; i++) {
            for (j = xJ; j < arJ; j++) {
                if (i + x1 == j + j1) {
                    result[count] = map[i][j];
                    count++;
                }
                if (result == winNorm) {
                    switch (s) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean win1J(int xI, int xJ, int arI, int arJ, char s) {
        char[] winNorm = new char[]{s, s, s, s};
        int i = 0, j = 0;
        for (i = xI; i < arI; i++) {
            char[] result = new char[]{s, s, s, s};
            for (j = xJ; j < arJ; j++) {
                for (int c = 0; c < 4; c++) {
                    result[c] = map[i][j + c];
                }
                if (result == winNorm) {
                    switch (s) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean win1I(int xI, int xJ, int arI, int arJ, char s) {
        char[] winNorm = new char[]{s, s, s, s};
        int i = 0, j = 0;
        for (i = xI; i < arI; i++) {
            char[] result = new char[]{s, s, s, s};
            for (j = xJ; j < arJ; j++) {
                for (int c = 0; c < 4; c++) {
                    result[c] = map[i + c][j];
                }
                if (result == winNorm) {
                    switch (s) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char s) {
        int i = 1;
        boolean result = false;
        switch (i) {
            case 1:
                result = win1I(0, 0, 2, SIZE, s);
                if (result == true) {
                    return true;
                }
            case 2:
                result = win1J(0, 0, SIZE, 2, s);
                if (result == true) {
                    return true;
                }
            case 3:
                result = win2(0, 0, SIZE - 1, SIZE - 1, s, 0, 0);
                if (result == true) {
                    return true;
                }
            case 4:
                result = win2(1, 1, SIZE - 1, SIZE - 1, s, 0, 0);
                if (result == true) {
                    return true;
                }
            case 5:
                result = win2(0, 1, SIZE - 1, SIZE, s, 1, 0);
                if (result == true) {
                    return true;
                }
            case 6:
                result = win2(1, 0, SIZE, SIZE - 1, s, 0, 1);
                if (result == true) {
                    return true;
                }
            case 7:
                result = win3(SIZE - 1, 0, SIZE - 1, SIZE - 1, s);
                if (result == true) {
                    return true;
                }
            case 8:
                result = win3(SIZE - 2, 1, SIZE - 1, SIZE - 1, s);
                if (result == true) {
                    return true;
                }
            case 9:
                result = win3(SIZE - 2, 0, SIZE - 1, SIZE - 1, s);
                if (result == true) {
                    return true;
                }
            case 10:
                result = win3(SIZE - 1, 1, SIZE - 1, SIZE - 1, s);
                if (result == true) {
                    return true;
                } else {
                    break;
                }
        }
        return result;
    }
}

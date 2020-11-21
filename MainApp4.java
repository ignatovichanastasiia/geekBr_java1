package ru.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainApp4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int WIN_STEP = 4;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'x';
    public static final char DOT_O = 'o';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int I;
    public static int J;
    public static int C;


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, DOT_X)) break;
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O, DOT_O)) break;
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        System.out.println("The end!");
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (I = 0; I < SIZE; I++) {
            for (J = 0; J < SIZE; J++) {
                map[I][J] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (I = 0; I <= SIZE; I++) {
            System.out.print(I + "  ");
        }
        System.out.println();
        for (I = 0; I < SIZE; I++) {
            System.out.print((I + 1) + "  ");
            for (J = 0; J < SIZE; J++) {
                System.out.print(map[I][J] + "  ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        do {
            System.out.println("Введите координаты в формате X Y");
            J = sc.nextInt() - 1;
            I = sc.nextInt() - 1;
        } while (isCellValid(J, I));
        map[I][J] = DOT_X;
    }

    public static void aiTurn() {
        if (checkWin(DOT_X, DOT_EMPTY)) return;
        else if (secCheckWin(DOT_X, DOT_EMPTY)) return;
        else {
            do {
                J = rand.nextInt(SIZE);
                I = rand.nextInt(SIZE);
            } while (isCellValid(J, I));
            System.out.println("Компьютер походил в точку " + (J + 1) + " " + (I + 1));
            map[I][J] = DOT_O;
        }
    }

    public static boolean isCellValid(int J, int I) {
        if (J < 0 || J >= SIZE || I < 0 || I >= SIZE) return true;
        return map[I][J] != DOT_EMPTY;
    }

    public static boolean isMapFull() {
        for (I = 0; I < SIZE; I++) {
            for (J = 0; J < SIZE; J++) {
                if (map[I][J] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char s, char p) {
        I = 1;
        boolean result;
        switch (I) {
            case 1:
                result = win1I(s, p); //вертикаль
                if (result) {
                    return true;
                }
            case 2:
                result = win1J(s, p); //горизонталь
                if (result) {
                    return true;
                }
            case 3:
                result = win2(0, 0, SIZE - 1, SIZE - 1, s, p, 0, 0); //диагональ 1-4
                if (result) {
                    return true;
                }
            case 4:
                result = win2(1, 1, SIZE - 1, SIZE - 1, s, p, 0, 0); //диагональ 2-5
                if (result) {
                    return true;
                }
            case 5:
                result = win2(0, 1, SIZE - 1, SIZE, s, p, 1, 0); //диагональ подочная верхняя
                if (result) {
                    return true;
                }
            case 6:
                result = win2(1, 0, SIZE, SIZE - 1, s, p, 0, 1); //диагональ подочная нижняя
                if (result) {
                    return true;
                }
            case 7:
                result = win3(SIZE - 1, 0, SIZE - 1, s, p); //диагональ 5-5
                if (result) {
                    return true;
                }
            case 8:
                result = win3(SIZE - 2, 1, SIZE, s, p); //диагональ 5-5 верхняя часть
                if (result) {
                    return true;
                }
            case 9:
                result = win3(SIZE - 2, 0, SIZE - 1, s, p); //диагональ побочная 4-4
                if (result) {
                    return true;
                }
            case 10:
                result = win3(SIZE - 1, 1, SIZE, s, p); //диагональ нижняя побочная
                if (result) {
                    return true;
                } else {
                    break;
                }
        }
        return false;
    }

    private static boolean win1I(char s, char p) {
        char[] winNorm = new char[]{s, s, s, p};
        for (I = 0; I < SIZE - 3; I++) {
            char[] result = new char[]{s, s, s, p};
            for (J = 0; J < SIZE; J++) {
                for (C = 0; C < WIN_STEP; C++) {
                    result[C] = map[I + C][J];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (p) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J + 1) + " " + ((I + C - 1) + 1));
                            map[I + C - 1][J] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean win1J(char s, char p) {
        char[] winNorm = new char[]{s, s, s, p};
        for (I = 0; I < SIZE; I++) {
            char[] result = new char[]{s, s, s, p};
            for (J = 0; J < SIZE - 3; J++) {
                for (C = 0; C < WIN_STEP; C++) {
                    result[C] = map[I][J + C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (p) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + ((J + C - 1) + 1) + " " + (I + 1));
                            map[I][J + C - 1] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean win2(int xI, int xJ, int arI, int arJ, char s, char p, int x1, int j1) {
        char[] result = new char[]{s, s, s, p};
        char[] winNorm = new char[]{s, s, s, p};
        int count = 0;
        for (I = xI; I < arI; I++) {
            for (J = xJ; J < arJ; J++) {
                if (I + x1 == J + j1) {
                    result[count] = map[I][J];
                    count++;
                }
            }
        }
        if (Arrays.equals(result, winNorm)) {
            switch (p) {
                case 'x':
                    System.out.println("Gamer! You win!");
                    break;
                case 'o':
                    System.out.println("Game over!");
                    break;
                default:
                    System.out.println("Компьютер походил в точку " + (J - 1 + 1) + " " + (I - 1 + 1));
                    map[I - 1][J - 1] = DOT_O;
            }
            return true;
        }
        return false;
    }

    private static boolean win3(int xI, int xJ, int arI, char s, char p) {
        char[] winNorm = new char[]{s, s, s, p};
        char[] result = new char[]{s, s, s, p};
        int count = 0;
        for (I = xI, J = xJ; J < arI; I--, J++) {
            result[count] = map[I][J];
            count++;
        }
        if (Arrays.equals(result, winNorm)) {
            switch (p) {
                case 'x':
                    System.out.println("Gamer! You win!");
                    return true;
                case 'o':
                    System.out.println("Game over!");
                    return true;
                default:
                    System.out.println("Компьютер походил в точку " + (J - 1 + 1) + " " + (I - 1 + 1));
                    map[I - 1][J - 1] = DOT_O;
            }
        }
        return false;
    }

    public static boolean secCheckWin(char s, char p) {
        I = 1;
        boolean result;
        switch (I) {
            case 1:
                result = backWin1I(s, p); //вертикаль
                if (result) {
                    return true;
                }
            case 2:
                result = backWin1J(s, p); //горизонталь
                if (result) {
                    return true;
                }
            case 3:
                result = backWin2(SIZE - 1, SIZE - 1, 1, 1, s, p, 0, 0); //диагональ 5-2
                if (result) {
                    return true;
                }
            case 4:
                result = backWin2(SIZE - 2, SIZE - 2, 0, 0, s, p, 0, 0); //диагональ 4-1
                if (result) {
                    return true;
                }
            case 5:
                result = backWin2(SIZE - 1, SIZE - 2, 1, 0, s, p, 0, 1); //нижняя диагональ
                if (result) {
                    return true;
                }
            case 6:
                result = backWin2(SIZE - 2, SIZE - 1, 0, 1, s, p, 1, 0); //верхняя диагональ
                if (result) {
                    return true;
                }
            case 7:
                result = backWin3(0, SIZE - 1, 1, s, p); //диагональ 5-5 верхняя часть
                if (result) {
                    return true;
                }
            case 8:
                result = backWin3(1, SIZE - 2, 0, s, p); //диагональ 5-5 нижняя часть
                if (result) {
                    return true;
                }
            case 9:
                result = backWin3(0, SIZE - 2, 0, s, p); //диагональ верхняя диагональ
                if (result) {
                    return true;
                }
            case 10:
                result = backWin3(1, SIZE - 1, 1, s, p); //диагональ нижняя диагональ
                if (result) {
                    return true;
                } else {
                    break;
                }
        }
        return false;
    }

    private static boolean backWin1I(char s, char p) {
        char[] winNorm = new char[]{s, s, s, p};
        for (I = SIZE - 1; I > SIZE - 3; I--) {
            char[] result = new char[]{s, s, s, p};
            for (J = SIZE - 1; J >= 0; J--) {
                for (C = 0; C < WIN_STEP; C++) {
                    result[C] = map[I - C][J];
                }
                if (Arrays.equals(result, winNorm)) {
                    System.out.println("Компьютер походил в точку " + (J + 1) + " " + ((I - C + 1) + 1));
                    map[I - C + 1][J] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backWin1J(char s, char p) {
        char[] winNorm = new char[]{s, s, s, p};
        for (I = SIZE - 1; I >= 0; I--) {
            char[] result = new char[]{s, s, s, p};
            for (J = SIZE - 1; J > SIZE - 3; J--) {
                for (C = 0; C < WIN_STEP; C++) {
                    result[C] = map[I][J - C];
                }
                if (Arrays.equals(result, winNorm)) {
                    System.out.println("Компьютер походил в точку " + ((J - C + 1) + 1) + " " + (I + 1));
                    map[I][J - C + 1] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backWin2(int xI, int xJ, int arI, int arJ, char s, char p, int x1, int j1) {
        char[] result = new char[]{s, s, s, p};
        char[] winNorm = new char[]{s, s, s, p};
        int count = 0;
        for (I = xI; I >= arI; I--) {
            for (J = xJ; J >= arJ; J--) {
                if (I + x1 == J + j1) {
                    result[count] = map[I][J];
                    count++;
                }
            }
        }
        if (Arrays.equals(result, winNorm)) {
            System.out.println("Компьютер походил в точку " + (J + 1 + 1) + " " + (I + 1 + 1));
            map[I + 1][J + 1] = DOT_O;
            return true;
        }
        return false;
    }

    private static boolean backWin3(int xI, int xJ, int arI, char s, char p) {
        char[] winNorm = new char[]{s, s, s, p};
        char[] result = new char[]{s, s, s, p};
        int count = 0;
        for (I = xI, J = xJ; J >= arI; I++, J--) {
            result[count] = map[I][J];
            count++;
        }
        if (Arrays.equals(result, winNorm)) {
            System.out.println("Компьютер походил в точку " + (J + 1 + 1) + " " + (I - 1 + 1));
            map[I - 1][J + 1] = DOT_O;
            return true;
        }
        return false;
    }
}
















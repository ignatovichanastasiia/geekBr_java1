package ru.lesson4VF;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4VF {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int WIN_STEP = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'x';
    public static final char DOT_O = 'o';
    public static char[] WIN_GAMER = new char[]{DOT_X, DOT_X, DOT_X};
    public static char[] WIN_AI = new char[]{DOT_O, DOT_O, DOT_O};
    public static char[] BEFORE_WIN = new char[]{DOT_X, DOT_X, DOT_EMPTY};
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
            if (checkWin(WIN_GAMER, DOT_X)) break;
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(WIN_AI, DOT_O)) break;
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
        if (checkWin(BEFORE_WIN, DOT_EMPTY)) return;
        else if (secCheckWin(BEFORE_WIN, DOT_EMPTY)) return;
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

    public static boolean checkWin(char[] s, char dot) {
        I = 1;
        boolean result;
        switch (I) {
            case 1:
                result = win1I(s, dot); //вертикаль
                if (result) {
                    return true;
                }
            case 2:
                result = win1J(s, dot); //горизонталь
                if (result) {
                    return true;
                }
            case 3:
                result = winD(s, dot); //диагонали
                if (result) {
                    return true;
                }
            case 4:
                result = winD2(s, dot); //диагонали
                if (result) {
                    return true;
                }
        }
        return false;
    }

    private static boolean win1I(char[] s, char dot) {
        char[] winNorm;
        winNorm = s.clone();
        for (I = 0; I < SIZE; I++) {
            for (J = 0; J < SIZE; J++) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && SIZE > I + C; C++) {
                    result[C] = map[I + C][J];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J + 1) + " " + (I + C - 1 + 1));
                            map[I + C - 1][J] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean win1J(char[] s, char dot) {
        char[] winNorm;
        winNorm = s.clone();
        for (I = 0; I < SIZE; I++) {
            for (J = 0; J < SIZE; J++) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && SIZE > J + C; C++) {
                        result[C] = map[I][J + C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J + C - 1 + 1) + " " + (I + 1));
                            map[I][J + C - 1] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean winD(char[] s, char dot) {
        char[] winNorm = new char[WIN_STEP];
        winNorm = s.clone();
        for (I = 0; I < SIZE; I++) {
            for (J = 0; J < SIZE; J++) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && SIZE > I + C && SIZE > J + C; C++) {
                        result[C] = map[I + C][J + C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J + C - 1 + 1) + " " + (I + C - 1 + 1));
                            map[I + C - 1][J + C - 1] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean winD2(char[] s, char dot) {
        char[] winNorm = new char[WIN_STEP];
        winNorm = s.clone();
        for (I = SIZE - 1; I >= 0; I--) {
            for (J = 0; J < SIZE; J++) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && 0 <= I - C && SIZE > J + C; C++) {
                        result[C] = map[I - C][J + C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J + C - 1 + 1) + " " + (I - C + 1 + 1));
                            map[I - C + 1][J + C - 1] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean secCheckWin(char[] s, char dot) {
        I = 1;
        boolean result;
        switch (I) {
            case 1:
                result = backWin1I(s, dot); //вертикаль
                if (result) {
                    return true;
                }
            case 2:
                result = backWin1J(s, dot); //горизонталь
                if (result) {
                    return true;
                }
            case 3:
                result = backWinD(s, dot); //диагонали
                if (result) {
                    return true;
                }
            case 4:
                result = backWinD2(s, dot); //диагонали
                if (result) {
                    return true;
                }
        }
        return false;
    }

    private static boolean backWin1I(char[] s, char dot) {
        char[] winNorm = new char[WIN_STEP];
        winNorm = s.clone();
        for (I = SIZE - 1; I >= 0; I--) {
            for (J = SIZE - 1; J >= 0; J--) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && 0 <= I - C; C++) {
                        result[C] = map[I - C][J];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J + 1) + " " + (I - C + 1 + 1));
                            map[I - C + 1][J] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backWin1J(char[] s, char dot) {
        char[] winNorm = new char[WIN_STEP];
        winNorm = s.clone();
        for (I = SIZE - 1; I >= 0; I--) {
            for (J = SIZE - 1; J >= 0; J--) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && 0 <= J - C; C++) {
                        result[C] = map[I][J - C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J - C + 1 + 1) + " " + (I + 1));
                            map[I][J - C + 1] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backWinD(char[] s, char dot) {
        char[] winNorm = new char[WIN_STEP];
        winNorm = s.clone();
        for (I = SIZE - 1; I >= 0; I--) {
            for (J = SIZE - 1; J >= 0; J--) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && 0 <= I - C && 0 <= J - C; C++) {
                        result[C] = map[I - C][J - C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J - C + 1 + 1) + " " + (I - C + 1 + 1));
                            map[I - C + 1][J - C + 1] = DOT_O;
                    }
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean backWinD2(char[] s, char dot) {
        char[] winNorm = new char[WIN_STEP];
        winNorm = s.clone();
        for (I = 0; I < SIZE; I++) {
            for (J = SIZE - 1; J >= 0; J--) {
                char[] result = new char[WIN_STEP];
                for (C = 0; C < WIN_STEP && SIZE > I + C && 0 <= J - C; C++) {
                        result[C] = map[I + C][J - C];
                }
                if (Arrays.equals(result, winNorm)) {
                    switch (dot) {
                        case 'x':
                            System.out.println("Gamer! You win!");
                            break;
                        case 'o':
                            System.out.println("Game over!");
                            break;
                        default:
                            System.out.println("Компьютер походил в точку " + (J - C + 1 + 1) + " " + (I + C - 1 + 1));
                            map[I + C - 1][J - C + 1] = DOT_O;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}


package ru.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainApp3 {

    public static Scanner scanner = new Scanner(System.in);
    public static int i = 0;
    public static int i2 = 0;
    public static String word = " ";
    public static String userAdd = " ";

    public static void main(String[] args) {
        System.out.println("Задача 1. ");
        guess(i);
        System.out.println("Задача 2. ");
        guess2();
    }

    private static void guess2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int a = randomNum(25);
        word = words[a];
        System.out.println("Загадано одно из " + words.length + "слов:");
        printArray(words);
        do {
            System.out.println("Угадайте слово:");
            String userAdd = scanner.next();
            String str1 = new String(word);
            String str2 = new String(userAdd);
            if (str1.equals(str2)) {
                System.out.println("Поздравляю! Вы угадали!");
                System.out.println("Игра окончена.");
                break;
            } else {
                System.out.println("Вы не угадали.");
                int wLength = wordLength(word, userAdd);
                int count = 0;
                String str3 = "";
                int plus = (15-wLength);
                String str4 = "";
                for (int k = 0; k < plus; k++) {
                    str4 = str4 + "#";
                }
                for(int i = 0; i < wLength; i++) {
                    char c = str1.charAt(i);
                    char b = str2.charAt(i);
                    if (str1.charAt(i) == str2.charAt(i)){
                        str3 = str3 + str1.charAt(i);
                    } else {
                        str3 = str3 + "#";
                    }
                }System.out.println("Совпадение: " + str3 + str4);
            }
        } while (true);
    }

    private static int wordLength(String a, String b) {
        int firstLength = count(a);
        int secondlength = count(b);
        int mainLength = 0;
        if (firstLength > secondlength) {
            mainLength = secondlength;
        } else {
            mainLength = firstLength;
        }return mainLength;
    }

    public static int count(String word) {
        String str = new String(word);
        int count = 0;
        for(int i = 0; i<str.length(); i++) {
            count++;
        }return count;
    }

    private static void printArray(String[] words) {
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + ", ");
        }
        System.out.println();
    }

    private static void guess(int i) {
        int x = 10;
        int rand = randomNum(x);
        do {
            i++;
            System.out.println("Угадайте число от 1 до " + (x - 1) + ". У вас 3 попытки. Попытка " + i + ":");
            int userAdd = scanner.nextInt();
            if (userAdd < rand) {
                System.out.println("Введенное число меньше загаданного.");
            } else if (userAdd > rand) {
                System.out.println("Введенное число больше загаданного.");
            } else {
                System.out.println("Поздравляю! Вы выиграли! Сыграем еще? (1 - да; 0 - нет.)");
                int step = scanner.nextInt();
                switch (step) {
                    case 0:
                        System.out.println("Игра окончена.");
                        i = 4;
                        break;
                    case 1:
                        System.out.println("Отлично! Играем!");
                        i = 0;
                        break;
                    default:
                        System.out.println("Команда не распознана. Игра окончена.");
                        i = 4;
                        break;
                }
            }
        } while (i < 3);
        if(i == 3){
            System.out.println("Вы проиграли! Загаданное число: " + rand + ". Сыграем еще? (1 - да; 0 - нет.)");
            int step = scanner.nextInt();
            switch (step) {
                case 0:
                    System.out.println("Игра окончена.");
                    break;
                case 1:
                    System.out.println("Отлично! Играем!");
                    i = 0;
                    guess(i);
                    break;
                default:
                    System.out.println("Команда не распознана. Игра окончена.");
                    break;
            }
        } else {
            System.out.println();
        }
    }

    private static int randomNum(int x) {
        Random random = new Random();
        int rand;
        return rand = random.nextInt(x);
    }
}

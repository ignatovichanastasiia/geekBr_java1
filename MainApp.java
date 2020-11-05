package ru.geekbrains.lesson1;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 4 числа для решения примера (a * (b + (c / d)): ");
        float a = scanner.nextInt();
        float b = scanner.nextInt();
        float c = scanner.nextInt();
        float d = scanner.nextInt();
        System.out.println(example(a, b, c, d));
        System.out.println("Введите 2 числа для сравнения суммы с диапозоном от 10 до 20: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(compare(x, y));
        System.out.println("Введите число, чтобы узнать, положтельное ли оно: ");
        int z = scanner.nextInt();
        System.out.println(posNeg(z));
        System.out.println("Введите число, чтобы узнать, отрицательное ли оно (метод 2): ");
        int w = scanner.nextInt();
        System.out.println(posNeg2(w));
        System.out.println("Введите свое имя: ");
        String name = scanner.next();
        hello(name);
        System.out.println("Введите год, чтобы узнать, високосный ли он: ");
        int year = scanner.nextInt();
        System.out.println(bigYear(year));
        scanner.close();
    }

    private static boolean bigYear(int year) {
        if(year%4==0 && year%100!=0||year%4==0&&year%400==0) {
            return true;
        }else return false;
    }

    private static void hello(String name) {
        System.out.println("Привет, "+name+" !");
    }

    private static boolean posNeg2(int w) {
        if(w>=0){
            return false;
        }else{
            return true;
        }
    }

    private static String posNeg(int z) {
        if(z>=0){
            return "positive";
        }else{
            return "negative";
        }
    }

    private static boolean compare(int x, int y) {
        int sum= x+y;
        if(sum>10&&sum<20){
            return true;
        }else{
            return false;
        }

    }

    private static float example(float a, float b, float c, float d) {
        float result;
        return result = a * (b + (c / d));
    }



    //Создать пустой проект в IntelliJ IDEA и прописать метод main().
    //Создать переменные всех пройденных типов данных и инициализировать их значения.
    //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float.
    //Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в
    // пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    //Написать метод, которому в качестве параметра передается целое число, метод должен
    // напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
}

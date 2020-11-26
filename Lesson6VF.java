package ru.lesson6VF;

import java.util.Scanner;

class Animal {
    private String name;
    private String type;
    private int id;
    static int counter = 1;

    public Animal(String name, String type) {
        this.type = type;
        this.name = name;
        id = counter++;
        System.out.println("id " + id);
    }

    public void animalInfo() {
        System.out.printf("%s %s.\n", type, name);
    }

    public int getCount() {
        return id;
    }

    public String getAnimalName() {
        return name;
    }

    public String getAnimalType() {
        return type;
    }

    public void run(int runDistance, int maxRunDistance) {
        name = getAnimalName();
        type = getAnimalType();
        if (runDistance > maxRunDistance) {
            System.out.printf("%s %s пробежал(а) %d метров и шмыгнул(а) в кусты,\n а оставшиеся %d метров никто не бежал.\n", type, name, maxRunDistance, (runDistance - maxRunDistance));
        } else {
            System.out.printf("%s %s, пробежал(а) %d метров.\n", type, name, runDistance);
        }
        System.out.println("Max distance: " + maxRunDistance);
    }

    public void swim(int swimDistance, int maxSwimDistance) {
        name = getAnimalName();
        type = getAnimalType();
        if (swimDistance > maxSwimDistance) {
            System.out.printf("%s %s проплыл(а) %d метров,\n и вылез(ла) на берег. Оставшиеся %d метров никто не плыл.\n", type, name, maxSwimDistance, (swimDistance - maxSwimDistance));
        } else {
            System.out.printf("%s %s проплыл(а) %d метров.\n", type, name, swimDistance);
        }
    }
}

class Cat extends Animal {
    private final int maxR = 200;

    public Cat(String name, String type) {
        super(name, type);
    }

    public int getMaxR() {
        return maxR;
    }

    public void swim(int swimDistance) {
        String name = getAnimalName();
        System.out.printf("При попытке столкнуть кота %s в воду, Вы упали сами и проплыли %s метров.\n", name, swimDistance);
    }
}

class Dog extends Animal {
    public final int maxR = 500;
    public final int maxS = 10;


    public Dog(String name, String type) {
        super(name, type);
    }

    public int getMaxR() {
        return maxR;
    }

    public int getMaxS() {
        return maxS;
    }
}

public class Lesson6VF {
    public static Scanner scanner = new Scanner(System.in);
    public static int runDistance;
    public static int swimDistance;
    public static String userAnswer;

    public static void main(String[] args) {
        Cat cat1 = new Cat("Васька","Кот");
        cat1.animalInfo();
        Cat cat2 = new Cat("Барсик","Кот");
        cat2.animalInfo();
        Dog dog1 = new Dog("Бобик","Собака");
        dog1.animalInfo();
        Dog dog2 = new Dog("Шарик","Собака");
        dog2.animalInfo();
        Dog dog3 = new Dog("Чарик","Собака");
        dog3.animalInfo();
        System.out.println("Животных: " + dog3.getCount());
        do {
            System.out.println("Сколько бежать?");
            runDistance = scanner.nextInt();
            int maxRunDistance = cat1.getMaxR();
            cat1.run(runDistance, maxRunDistance);
            cat2.run(runDistance, maxRunDistance);
            maxRunDistance = dog1.getMaxR();
            dog1.run(runDistance, maxRunDistance);
            dog2.run(runDistance, 400);
            dog3.run(runDistance, 600);
            System.out.println("Сколько плыть?");
            swimDistance = scanner.nextInt();
            cat1.swim(swimDistance);
            cat2.swim(swimDistance);
            int maxSwimDistance = dog1.getMaxS();
            dog1.swim(swimDistance, maxSwimDistance);
            dog2.swim(swimDistance, maxSwimDistance);
            dog3.swim(swimDistance, maxSwimDistance);
            System.out.println("Выходим? Y/N");
            userAnswer = scanner.next();
        } while (!userAnswer.equals("y") && !userAnswer.equals("Y"));
    }

    //Создать классы Собака и Кот с наследованием от класса Животное.
    //Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    //Результатом выполнения действия будет печать в консоль.
    // (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    //У каждого животного есть ограничения на действия
    // (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    //* Добавить подсчет созданных котов, собак и животных.
    //5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
    // может быть 400 м., у другой 600 м.

}
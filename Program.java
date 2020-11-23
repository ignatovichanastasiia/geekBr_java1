package ru.lesson6;

import java.util.Scanner;

class Animal {
    String name;
    public int id;
    static int counter=1;


    public Animal(String name) {
        this.name = name;
        id = counter++;
        System.out.println("id "+ id);
    }

    public int getCount(){
        return id;
    }

    public void run(int runDistance) {
        System.out.printf("Животное пробежало %d метров.\n", runDistance);
    }

    public void swim(int swimDistance) {
        System.out.printf("Животное проплыло %d метров.\n", swimDistance);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public void catInfo() {
        System.out.printf("Кот: %s.\n", name);
    }

    public String getCatName() {
        return name;
    }

    public void run(int runDistance) {
        name = getCatName();
        if(runDistance>200) {
            System.out.printf("Кот %s пробежал 200 метров и шмыгнул в кусты,\n а оставшиеся %d метров никто не бежал.\n", name, (runDistance - 200));
        } else {
            System.out.printf("Кот %s. ", name);
            super.run(runDistance);
        }
    }

    public void swim(int swimDistance) {
        name = getCatName();
        System.out.printf("При попытке столкнуть кота %s в воду, Вы упали сами и проплыли %s метров.\n", name, swimDistance);
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public String getDogName() {
        return name;
    }

    public void dogInfo() {
        System.out.printf("Собака: %s\n", name);
    }

    public void run(int runDistance) {
        name = getDogName();
        if(runDistance>500) {
            System.out.printf("Собака %s пробежала 500 метров,\n а оставшиеся %d метров бежать отказалась.\n", name, (runDistance - 500));
        } else {
            System.out.printf("Собака %s. ", name);
            super.run(runDistance);
        }
    }

    public void swim(int swimDistance) {
        name = getDogName();
        if(swimDistance>10) {
            System.out.printf("Собака %s проплыла 10 метров,\n вылезла на берег и отряхнулась. Вы отскочили на %d метров.\n", name, (swimDistance - 10));
        } else {
            System.out.printf("Собака %s. ", name);
            super.swim(swimDistance);
        }
    }

    public void run(int runDistance, int maxDistance) {
        name = getDogName();
        if(runDistance>maxDistance) {
            System.out.printf("Собака %s пробежала %d метров,\n а оставшиеся %d метров бежать отказалась.\n", name, maxDistance, (runDistance - maxDistance));
        } else {
            System.out.printf("Собака %s. ", name);
            super.run(runDistance);
        }
        System.out.println("Max distance: "+maxDistance);
    }
}

public class Program {
    public static Scanner scanner = new Scanner(System.in);
    public static int runDistance;
    public static int swimDistance;
    public static String userAnswer;


    public static void main(String[] args) {
        Cat cat1 = new Cat("Васька");
        cat1.catInfo();
        Cat cat2 = new Cat("Барсик");
        cat2.catInfo();
        Dog dog1 = new Dog("Бобик");
        dog1.dogInfo();
        Dog dog2 = new Dog("Шарик");
        dog2.dogInfo();
        Dog dog3 = new Dog("Чарик");
        dog3.dogInfo();
        System.out.println("Животных: " + dog3.getCount());
        do {
            System.out.println("Сколько бежать?");
            runDistance = scanner.nextInt();
            cat1.run(runDistance);
            dog1.run(runDistance);
            dog2.run(runDistance,400);
            dog3.run(runDistance,600);
            System.out.println("Сколько плыть?");
            swimDistance = scanner.nextInt();
            cat1.swim(swimDistance);
            dog1.swim(swimDistance);
            dog2.swim(swimDistance);
            dog3.swim(swimDistance);
            System.out.println("Выходим? Y/N");
            userAnswer = scanner.next();
        } while (!userAnswer.equals("y")&&!userAnswer.equals("Y"));
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

package lesson5;

import java.util.Arrays;

public class PerMain {
    public static Person person1 = new Person("Иванов Иван","кассир","person1@mail.ru","89001111111","30000",25);
    public static Person person2 = new Person("Петров Петя","продавец","person2@mail.ru","89002222222","40000",30);
    public static Person person3 = new Person("Сидорова Алена","продавец","person3@mail.ru","89003333333","40000",45);
    public static Person person4 = new Person("Катенина Катя","уборщица","person4@mail.ru","89004444444","20000",46);
    public static Person person5 = new Person("Зимин Дмитрий","охранник","person5@mail.ru","89005555555","30000",55);
    public static int [] personsA = new int [5];

    public static void main(String[] args) {
        personsA = takeAge();
        System.out.print(Arrays.toString(personsA));
        System.out.println();
        someAges(personsA);


    }

    public static void takeInfo(int x){
        switch (x) {
            case 0:
                person1.perInfo();
                break;
            case 1:
                person2.perInfo();
                break;
            case 2:
                person3.perInfo();
                break;
            case 3:
                person4.perInfo();
                break;
            case 4:
                person5.perInfo();
                break;
        }
    }

    public static int[] takeAge(){
        personsA[0] = person1.getAge();
        personsA[1] = person2.getAge();
        personsA[2] = person3.getAge();
        personsA[3] = person4.getAge();
        personsA[4] = person5.getAge();
        return personsA;
    }

    public static void someAges(int[] persons){
        for (int i = 0;i < 5; i++) {
            int a = persons[i];
            if(a > 40) {
                takeInfo(i);
                System.out.println();
            }
        }
    }
}






















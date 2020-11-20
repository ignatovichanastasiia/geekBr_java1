package lesson5;


public class Person {
    String name;
    String position;
    String mail;
    String number;
    String salary;
    int age;

    Person(String name, String position, String mail, String number, String salary, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void perInfo(){
        System.out.println("Сотрудник компании.");
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.println("E-mail: " + mail);
        System.out.println("Телефон: " + number);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public int getAge(){
        return age;
    }
}






























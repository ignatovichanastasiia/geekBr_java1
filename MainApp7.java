package ru.lesson7;

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food < n) {
            return false;
        } else {
            food -= n;
        }
        return true;
    }

    public void info() {
        System.out.printf("Тарелка: %d.\n", food);
    }

    public void addFood(int f) {
        food += f;
        System.out.printf("Тарелка наполнена на %d. Тарелка: %d.\n", f, food);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean s) {
        this.satiety = s;
    }

    public void eat(Plate p) {
        String nm = getName();
        satiety = getSatiety();
        if (satiety) {
            System.out.printf("%s уже сыт. ", nm);
        } else {
            if (p.decreaseFood(appetite)) {
                System.out.printf("%s поел. ", nm);
                setSatiety(true);
            } else {
                System.out.printf("%s голоден. ", nm);
            }
        }
    }

    public void hungry() {
        String nm = getName();
        satiety = getSatiety();
        if (getSatiety()) {
            setSatiety(false);
            System.out.printf("%s снова голоден. \n", nm);
        } else {
            System.out.printf("%s почти умер от голода. ", nm);
        }
    }
}

public class MainApp7 {
    public static Cat CAT1 = new Cat("Барсик", 5);
    public static Cat CAT2 = new Cat("Персик", 5);
    public static Cat CAT3 = new Cat("Тимик", 5);
    public static Cat[] CATS = {CAT1, CAT2, CAT3};
    public static Plate PLATE = new Plate(25);

    public static void main(String[] args) {
        PLATE.info();
        eatAll(CATS);
        eatAll(CATS);
        PLATE.info();
        hungryAll(CATS);
        eatAll(CATS);
        PLATE.addFood(10);
        eatAll(CATS);
    }

    public static void eatAll(Cat[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].eat(PLATE);
            PLATE.info();
        }
    }

    public static void hungryAll(Cat[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].hungry();
        }
    }


    //+Расширить задачу про котов и тарелки с едой.
    //+Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    //+ (например, в миске 10 еды, а кот пытается покушать 15-20).
    //+Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    //+Если коту удалось покушать (хватило еды), сытость = true.
    //+Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
    // то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
    //+Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
    //+потом вывести информацию о сытости котов в консоль.
    //+Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
}

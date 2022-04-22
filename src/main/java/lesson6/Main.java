package lesson6;

public class Main {
    public static void main(String[] args) {
        Bowl b = new Bowl(70);
        b.addFood(30);

        Cat[] cats = {
                new Cat("Bars", 15),
                new Cat("Pushok", 20),
                new Cat("Pryanik", 15),
                new Cat("Snezhka", 10)
    };
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(b);
        }
    }
}

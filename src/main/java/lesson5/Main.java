package lesson5;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
    Dog Bobik = new Dog ("Bobik", "Gray", 5);
    Bobik.swim(10);
    Bobik.run(375);

    Cat w = new Cat ("Franky", "White", 2);
    w.run(-1);
    w.swim(5);

    Cat q = new Cat();
    Cat t = new Cat();
    Dog d = new Dog();

    animalCount();
    }
    public static void animalCount(){
        System.out.println("Animal count: " + Animals.count);
    }
}

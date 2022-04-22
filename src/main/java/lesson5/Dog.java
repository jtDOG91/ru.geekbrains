package lesson5;

public class Dog extends Animals {

    public Dog(String name, String color, int age) {
        super(name, color, age);
        this.canRun = 500;
        this.canSwim = 10;
    }
    public Dog (){
        super();
    }
}

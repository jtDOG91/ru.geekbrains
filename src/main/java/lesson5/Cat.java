package lesson5;

public class Cat extends Animals {

    public Cat(String name, String color, int age){
        super(name, color, age);
        this.canRun = 200;
        this.canSwim = 0;
    }
    public Cat(){
        super();
    }

}

package lesson5;

public class Animals {
    String name;
    String color;
    int age;
    static int count = 0;
    int canRun;
    int canSwim;

    public Animals(){
        count++;
    }
    public Animals(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        count++;
    }
    public void run (int distance){
        if (canRun >= distance && distance > 0) System.out.printf("%s run %d metres!\n", name, distance);
        else System.out.printf("%s can't run %d metres!\n", name, distance);
    }

    public void swim (int distance){
        if (canSwim >= distance && canSwim > 0) {System.out.printf("%s swim %d metres!\n", name, distance); return;}
        if (canSwim <= 0) {System.out.printf("%s can't swims!\n", name); return;}
        else System.out.printf("%s can't swims so many!\n", name);
    }


}

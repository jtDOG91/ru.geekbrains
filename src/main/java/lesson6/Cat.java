package lesson6;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Bowl bowl){
        if (bowl.getFood() >= appetite) {
            System.out.printf("Cat %s is eating\n", name);
            System.out.printf("Cat %s is satiety\n", name);
            bowl.decreaseFood(appetite);
        }
        else System.out.printf("It's so few food to cat %s\n", name);
    }




    public String getName() {
        return name;
    }
    public int getAppetite() {
        return appetite;
    }
    public void setName() {
        this.name = name;
    }
    public void setAppetite() {
        this.appetite = appetite;
    }
}

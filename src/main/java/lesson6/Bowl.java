package lesson6;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public void decreaseFood(int appetite){
        food -= appetite;
        System.out.println("Now food are: " + food);
    }
    public void addFood(int moreFood){
        this.food += moreFood;
        System.out.println("We are add food in bowl, now food are " + food);
    }

    public int getFood() {
        return food;
    }
    public void setFood() {
        this.food = food;
    }
}

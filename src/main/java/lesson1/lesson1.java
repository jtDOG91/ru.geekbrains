package lesson1;

public class lesson1 {
    public static void main(String[] args) {
        six(2000);
    }
    public static float one(){
        float a = 1.5f;
        float b = 1.7f;
        float c = 2.2f;
        float d = 3.7f;
        float w = a*(b+(c/d));
        return w;
    }
    public static boolean two(int a, int b){
        boolean r;
        if (a + b >= 10 && a + b <= 20) {
            r = true;
        }
        else {
            r = false;
        }
        return r;
    }
    public static void tree(int a){
        int w = a % 2;
        if (a == 0){
            System.out.println("положительное");
        }
        else if (w == 0){
            System.out.println("отрицательное");
        }
        else {
            System.out.println("положительное");
        }
    }
    public static boolean four(int a) {
        boolean result;
        if (a < 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public static void five(String a){
        System.out.println("Привет, " + a + "!");
    }
    public static void six(int a){
        if (a % 100 == 0 && a % 400 != 0){
            System.out.println("не високосный");
        }
        else if (a % 400 == 0 || a % 4 == 0){
            System.out.println("високосный");
        }
        else {
            System.out.println("не високосный");
        }
    }
}

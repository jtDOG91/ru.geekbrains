package ru.geekbrains;

import java.util.Arrays;

public class lesson2 {
    public static void main(String[] args) {
//        one();
//        two();
//        three();
//        four();
//        five();
//        int[] e = {1, 2, 3, 4, 5};
//        System.out.println(six(e));
//        seven(e, 4);
    }
        public static void one() {
            int[] w = {1, 1, 0, 1, 0, 0, 1, 0};
            for (int i = 0; i < w.length; i++) {
                if (w[i] == 1) {
                    w[i] -= 1;
                }
                else {
                    w[i] += 1;
                }
            }
            System.out.println(Arrays.toString(w));
        }
        public static void two () {
        int[] t = new int[8];
        int w = 0;
        for (int i = 0; i < t.length; i++){
            t[i] = w;
            w +=3;
        }
            System.out.println(Arrays.toString(t));
        }
        public static void three(){
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < a.length; i++){
            if (a[i] < 6){
                a[i] *= 2;
            }
        }
            System.out.println(Arrays.toString(a));
        }
        public static void four(){
        int [][] a = new int [15][15];
        for (int i = 0; i < a.length; i++){
            a[i][i] = 1;
        }
        for (int q = 0, w = a.length -1; q < a.length; q++, w--){
            a[q][w] = 1;
            }
        for (int r = 0; r < a.length; r++){
            for (int y = 0; y < a.length; y++){
                System.out.print(a[r][y] + " ");
            }
            System.out.println();
        }
        }
        public static void five(){
        int[] a = {12, 3, 5, 7, 44, 56, 2 ,76, 0, -1, 99};
        int w = a[0];
        int e = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] > w){
                w = a[i];
            }
            if (a[i] < e){
                e = a[i];
            }
        }
            System.out.println("Max=" + w + " " + "Min=" + e);
        }
        public static boolean six(int[] w){
        int t = 0;
        for (int i = 0; i < w.length; i++){
            int e = i +1;
            int q = 0;
            t += w[i];
            for (; e < w.length; e++){
                q += w[e];
            }
            if (t == q){
                return true;
            }
        }
        return false;
        }
        public static void seven(int[] e, int n){
        for (int i = 0; i < Math.abs(n); i++){
        if (n > 0){
            int s = e[0];
            int r = e[e.length - 1];
            for (int t = 0; t < e.length - 1; t++){
                int w = e[t + 1];
                e[t + 1] = s;
                s = w;
            }
            e[0] = r;
        }
        else {
            int s = e[0];
            int r = e[e.length - 1];
            for (int t = e.length - 1; t > 0; t--){
                int w = e[t-1];
                e[t - 1] = r;
                r = w;
            }
            e[e.length - 1] = s;
        }
        }
            System.out.println(Arrays.toString(e));
        }
}
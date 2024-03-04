package BaekJoon.FlyMeToTheAlphaCentauri;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T;
        long x,y;

        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            x = sc.nextLong();
            y = sc.nextLong();

            long dis = y - x;
            long max = (int) Math.sqrt(dis);

            if (max == Math.sqrt(dis)) {
                System.out.println(2 * max - 1);
            } else if (dis <= max * max + max) {
                System.out.println(2 * max);
            } else{
                System.out.println(2 * max + 1);
            }
        }
    }
}

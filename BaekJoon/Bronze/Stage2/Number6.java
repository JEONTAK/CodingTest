package BaekJoon.Bronze.Stage2;

import java.util.Scanner;

public class Number6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = (B + C) % 60;
        int E = (B + C) / 60;
        int F = (A + E) % 24;
        System.out.println(F + " " + D);
    }
}

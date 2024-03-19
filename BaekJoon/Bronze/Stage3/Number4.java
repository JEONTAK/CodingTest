package BaekJoon.Bronze.Stage3;

import java.util.Scanner;

public class Number4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = 0;
        for (int i = 0; i < B; i++) {
            C += (sc.nextInt() * sc.nextInt());
        }
        if (A == C) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

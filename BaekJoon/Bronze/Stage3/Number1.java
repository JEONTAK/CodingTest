package BaekJoon.Bronze.Stage3;

import java.util.Scanner;

public class Number1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        for (int i = 1; i < 10; i++) {
            System.out.println(A + " * " + i + " = " + (A * i));
        }
    }
}

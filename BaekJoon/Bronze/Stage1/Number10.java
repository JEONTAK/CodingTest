package BaekJoon.Bronze.Stage1;

import java.util.Scanner;

public class Number10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A * (B % 10));
        System.out.println(A * ((B / 10) % 10));
        System.out.println(A * (B / 100));
        System.out.println(A * B);
    }
}

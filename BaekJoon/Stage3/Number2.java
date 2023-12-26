package BaekJoon.Stage3;

import java.util.Scanner;

public class Number2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        for (int i = 0; i < A; i++) {
            System.out.println((sc.nextInt() + sc.nextInt()));
        }
    }
}

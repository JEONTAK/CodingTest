package BaekJoon.Stage3;

import java.util.Scanner;

public class Number5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        for (int i = 0; i < (A / 4); i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}

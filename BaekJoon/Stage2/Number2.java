package BaekJoon.Stage2;

import java.util.Scanner;

public class Number2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String grade = A >= 90 ? "A" : A >= 80 ? "B" : A >= 70 ? "C" : A >= 60 ? "D" : "F";
        System.out.println(grade);
    }
}

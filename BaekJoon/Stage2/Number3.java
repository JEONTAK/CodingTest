package BaekJoon.Stage2;

import java.util.Scanner;

public class Number3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int year = ((A % 4) == 0) && ((A % 100) != 0) ? 1 : (A % 400) == 0 ? 1 : 0;
        System.out.println(year);
    }
}

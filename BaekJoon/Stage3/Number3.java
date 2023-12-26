package BaekJoon.Stage3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Number3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        System.out.println(IntStream.rangeClosed(1, A).sum());
    }
}

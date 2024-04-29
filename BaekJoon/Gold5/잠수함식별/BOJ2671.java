package BaekJoon.Gold5.잠수함식별;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2671 {

    static String input;
    static String pattern = "(100+1+|01)+";

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        if (input.matches(pattern)) {
            System.out.println("SUBMARINE");
        }else{
            System.out.println("NOISE");
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2671.solution();
    }
}

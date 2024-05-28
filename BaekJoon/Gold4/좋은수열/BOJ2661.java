package BaekJoon.Gold4.좋은수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2661 {

    static int N;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        compute("");
    }

    static void compute(String result) {
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if(isAvailable(result + i)) compute(result + i);
        }
    }

    static boolean isAvailable(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ2661.solution();
    }
}

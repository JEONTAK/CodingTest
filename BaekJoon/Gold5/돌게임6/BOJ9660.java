package BaekJoon.Gold5.돌게임6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9660 {

    static long N;
    static String SK = "SK", CY = "CY";

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        if (N % 7 == 0 || N % 7 == 2) {
            System.out.println(CY);
        }else{
            System.out.println(SK);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ9660.solution();
    }
}

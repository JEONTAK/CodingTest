package BaekJoon.Gold5._2의멱수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2410 {

    static int N;
    static int dp[];

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i - 1] + dp[i/2]) % 1_000_000_000;
            }else{
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[N]);
    }
    public static void main(String[] args) throws IOException {
        BOJ2410.solution();
    }
}

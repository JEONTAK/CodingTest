package BaekJoon.Gold5.크리보드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11058 {
    static int N;
    static long[] dp;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
        }
        for (int i = 7; i <= N; i++) {
            for (int j = 4; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 3] * (i - j + 2));
            }
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        BOJ11058.solution();
    }
}

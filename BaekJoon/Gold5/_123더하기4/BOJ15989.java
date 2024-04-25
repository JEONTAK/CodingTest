package BaekJoon.Gold5._123더하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989 {

    static int T;
    static int[] N;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, N[i]);
        }
        dp = new int[max + 1][4];
        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1 + 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1 + 1 + 1
        dp[3][2] = 1; // dp[3][2] = 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= max; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[N[i]][1] + dp[N[i]][2] + dp[N[i]][3] + "\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws IOException {
        BOJ15989.solution();
    }
}

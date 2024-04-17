package BaekJoon.Gold5.공통부분문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5582 {

    static char[] N,M;
    static int[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine().toCharArray();
        M = br.readLine().toCharArray();
        dp = new int[N.length + 1][M.length + 1];
        int max = 0;
        for (int i = 1; i <= N.length; i++) {
            for (int j = 1; j <= M.length; j++) {
                if (N[i - 1] == M[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BOJ5582.solution();
    }
}

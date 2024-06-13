package BaekJoon.Gold3.행렬곱셈순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11049 {

    static int N;
    static int[] size;
    static long[][] dp;
    static final long INF = Long.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            size[i] = a;
            size[i + 1] = b;
        }
        dp = new long[N][N];
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                dp[j][j + i - 1] = INF;
                for (int k = j; k < j + i - 1; k++) {
                    long v = dp[j][k] + dp[k + 1][j + i - 1] + (size[j] * size[k + 1] * size[j + i]);
                    dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], v);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }

    public static void main(String[] args) throws IOException {
        BOJ11049.solution();
    }
}

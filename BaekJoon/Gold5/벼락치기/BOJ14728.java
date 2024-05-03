package BaekJoon.Gold5.벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14728 {

    static int N, T;
    static int[][] unit;
    static int[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        unit = new int[N + 1][2];
        dp = new int[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            unit[i][0] = K;
            unit[i][1] = S;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= T; j++) {
                if (unit[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - unit[i][0]] + unit[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][T]);
    }

    public static void main(String[] args) throws IOException {
        BOJ14728.solution();
    }
}

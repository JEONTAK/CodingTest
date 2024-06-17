package BaekJoon.Gold3.파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11066 {

    static int T, K;
    static int[] file, sum;
    static int[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int a = 0; a < T; a++) {
            K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            file = new int[K + 1];
            dp = new int[K + 1][K + 1];
            sum = new int[K + 1];
            for (int i = 1; i <= K; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + file[i];
            }
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j + i <= K; j++) {
                    int t = i + j;
                    dp[j][t] = Integer.MAX_VALUE;
                    for (int k = j; k < t; k++) {
                        dp[j][t] = Math.min(dp[j][t], dp[j][k] + dp[k + 1][t] + sum[t] - sum[j - 1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ11066.solution();
    }
}

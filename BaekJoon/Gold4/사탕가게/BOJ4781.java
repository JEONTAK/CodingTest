package BaekJoon.Gold4.사탕가게;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4781 {

    static int N;
    static double M;
    static int[][] candy;
    static int[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Double.parseDouble(st.nextToken());
            int m = (int) (M * 100 + 0.5);
            if (N == 0 && m == 0) {
                break;
            }
            candy = new int[N][2];
            dp = new int[m + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                double c = Double.parseDouble(st.nextToken());
                int cost = (int) (c * 100 + 0.5);
                candy[i][0] = k;
                candy[i][1] = cost;
            }
            for (int i = 0; i < N; i++) {
                for (int j = candy[i][1]; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - candy[i][1]] + candy[i][0]);
                }
            }
            System.out.println(dp[m]);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ4781.solution();
    }
}


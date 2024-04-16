package BaekJoon.Gold5.연속합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13398 {

    static int N;
    static int[] sequence;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sequence = new int[N + 1];
        dp = new int[N + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = sequence[1];
        dp[1][1] = sequence[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + sequence[i], sequence[i]);
            dp[i][1] = Math.max(dp[i - 2][0] + sequence[i], dp[i - 1][1] + sequence[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 2; j++) {
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BOJ13398.solution();
    }
}

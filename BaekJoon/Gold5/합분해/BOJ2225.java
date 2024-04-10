package BaekJoon.Gold5.합분해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225 {

    static int N, K;
    static int[] dp;
    static final Integer MOD = 1000000000;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j] = (dp [j] + dp[j - 1]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        BOJ2225.solution();
    }
}

package BaekJoon.Gold5.동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9084 {
    static int T, N, M;
    static int[] coin;
    static long[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coin = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new long[M + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (k - coin[j] > 0) {
                        dp[k] = dp[k] + dp[k - coin[j]];
                    } else if (k - coin[j] == 0) {
                        dp[k]++;
                    }
                }
            }
            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BOJ9084.solution();
    }
}

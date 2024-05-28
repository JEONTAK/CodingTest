package BaekJoon.Gold4.작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2056 {

    static int N;
    static int[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dp = new int[N + 1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            dp[i] = t;
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[temp] + t);
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ2056.solution();
    }
}

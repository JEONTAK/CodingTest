package BaekJoon.Gold4.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10422 {

    static int T, L;
    static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 2; i < 2501; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += (dp[j * 2] * dp[(i - 1 - j) * 2]);
                dp[i * 2] %= 1000000007L;
            }
        }
        for (int a = 0; a < T; a++) {
            L = Integer.parseInt(br.readLine());
            sb.append(dp[L]).append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BOJ10422.solution();
    }
}

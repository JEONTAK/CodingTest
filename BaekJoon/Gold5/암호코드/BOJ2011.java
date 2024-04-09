package BaekJoon.Gold5.암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2011 {

    static int[] dp;
    static final int MOD = 1000000;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        dp = new int[str.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            int cur = str.charAt(i - 1) - '0';
            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
            if (i == 1) {
                continue;
            }
            int prev = str.charAt(i - 2) - '0';
            if (prev == 0) {
                continue;
            }
            int value = prev * 10 + cur;
            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }

    public static void main(String[] args) throws IOException {
        BOJ2011.solution();
    }
}

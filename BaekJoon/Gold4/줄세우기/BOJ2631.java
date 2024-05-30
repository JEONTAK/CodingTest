package BaekJoon.Gold4.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2631 {

    static int N;
    static int[] baby, dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        baby = new int[N];
        for (int i = 0; i < N; i++) {
            baby[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[N];
        int max = 0 ;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (baby[j] < baby[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(N - max);
    }

    public static void main(String[] args) throws IOException {
        BOJ2631.solution();
    }
}

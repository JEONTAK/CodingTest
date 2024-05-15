package BaekJoon.Gold4.타일채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133 {

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 1];
        dp[0] = 1;
        for (int i = 2; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        BOJ2133.solution();
    }
}

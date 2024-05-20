package BaekJoon.Gold4.가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1915 {

    static int N, M;
    static int[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][M + 1];
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                int input = Integer.parseInt(temp[j - 1]);
                if (i == 1 && j == 1) {
                    dp[i][j] = input;
                } else {
                    if (input == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans * ans);

    }

    public static void main(String[] args) throws IOException {
        BOJ1915.solution();
    }
}

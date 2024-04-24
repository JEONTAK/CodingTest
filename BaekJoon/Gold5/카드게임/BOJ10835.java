package BaekJoon.Gold5.카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10835 {

    static int N;
    static int[] left, right;
    static int[][] dp;
    static int max = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = new int[N];
        right = new int[N];
        dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                if (left[i] > right[j]) {
                    dp[i][j + 1] = Math.max(dp[i][j] + right[j], dp[i][j + 1]);
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i <= N; i++) {
            max = Math.max(max, Math.max(dp[N][i], dp[i][N]));
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BOJ10835.solution();
    }
}

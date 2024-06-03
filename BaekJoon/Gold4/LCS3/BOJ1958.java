package BaekJoon.Gold4.LCS3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1958 {

    static String[] str = new String[3];
    static int[][][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            str[i] = br.readLine();
        }
        dp = new int[str[0].length() + 1][str[1].length() + 1][str[2].length() + 1];
        for (int i = 1; i <= str[0].length(); i++) {
            for (int j = 1; j <= str[1].length(); j++) {
                for (int k = 1; k <= str[2].length(); k++) {
                    if (str[0].charAt(i - 1) == str[1].charAt(j - 1) && str[1].charAt(j - 1) == str[2].charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        int a = str[0].length();
        int b = str[1].length();
        int c = str[2].length();
        System.out.println(dp[a][b][c]);
    }

    public static void main(String[] args) throws IOException {
        BOJ1958.solution();
    }
}

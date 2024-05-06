package BaekJoon.Gold5.문자열판별;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ16500 {

    static String S;
    static int N;
    static Set<String> A;
    static int[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        N = Integer.parseInt(br.readLine());
        A = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (S.contains(word)) {
                A.add(word);
            }
        }
        dp = new int[S.length()];
        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < S.length(); j++) {
                if (dp[j] == 1 && A.contains(S.substring(i, j))) {
                    dp[i] = 1;
                }
            }
            if (A.contains(S.substring(i))) {
                dp[i] = 1;
            }
        }
        System.out.println(dp[0]);
    }

    public static void main(String[] args) throws IOException {
        BOJ16500.solution();
    }
}

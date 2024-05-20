package BaekJoon.Gold4.LCS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ9252 {
    static String A, B;
    static int dp[][];
    static int len = 0;
    static ArrayList<Character> list = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int a = A.length();
        int b = B.length();
        System.out.println(dp[a][b]);
        Stack<Character> s = new Stack<>();
        while (a > 0 && b > 0) {
            if (dp[a][b] == dp[a - 1][b]) {
                a--;
            } else if (dp[a][b] == dp[a][b - 1]) {
                b--;
            }else{
                s.push(A.charAt(a - 1));
                a--;
                b--;
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ9252.solution();
    }
}

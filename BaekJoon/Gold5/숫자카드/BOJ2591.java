package BaekJoon.Gold5.숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2591 {

    static String N;
    static int[][]dp;
    static ArrayList<Integer> card = new ArrayList<>();

    /*private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        int idx = 0;
        for (int i = 0; i < N.length(); i++) {
            int c = Integer.parseInt(String.valueOf(N.charAt(i)));
            if (c == 0) {
                if (idx == 0) {
                    System.out.println(0);
                    System.exit(0);
                }else{
                    if (card.get(idx - 1) * 10 + c <= 34) {
                        card.add(idx - 1 , card.get(idx -1) * 10 + c);
                        card.remove(idx);
                    }else{
                        System.out.println(0);
                        System.exit(0);
                    }
                }
            }else{
                card.add(c);
                idx++;
            }
        }

        int max = card.size() / 2;
        dp = new int[card.size() + 1][max + 1];
        for (int i = 1; i < dp.length; i++) {
                dp[i][0] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= max; j++) {
                if (j == 1) {
                    int front = card.get(i - 2);
                    int end = card.get(i - 1);
                    int digit = (end >= 10) ? 100 : 10;
                    if ((front * digit + end)<= 34) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }else{
                    dp[i][j] = Math.max(0, dp[i - 1][j - 1] + dp[i][j - 1] - (j + 1));
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < dp[0].length; i++) {
            sum += dp[dp.length - 1][i];
        }
        System.out.println(sum);
    }*/

    private static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < N; i++) {
            dp[i + 1] += dp[i];
            if (isAvailable(s.charAt(i - 1), s.charAt(i))) {
                dp[i + 1] += dp[i - 1];
            }
            if (s.charAt(i) == '0') {
                dp[i + 1] -= dp[i];
            }
        }
        System.out.println(dp[N]);
    }

    static boolean isAvailable(char c1, char c2) {
        if(c1 == '0') return false;
        int num = (c1 - '0') * 10 + (c2 - '0');
        return 1 <= num && num <= 34;
    }

    public static void main(String[] args) throws IOException {
        BOJ2591.solution();
    }
}

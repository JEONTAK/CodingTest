package BaekJoon.Gold5.A와B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12919 {

    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        compute(S, T);
        System.out.println(result);
    }
    static void compute(StringBuilder s, StringBuilder t){
        if (s.length() == t.length()) {
            if (s.toString().equals(t.toString())) {
                result = 1;
            }
            return;
        }
        if (t.charAt(0) == 'B') {
            StringBuilder temp = new StringBuilder(t);
            temp.reverse();
            temp.deleteCharAt(temp.length() - 1);
            compute(s, temp);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            t.deleteCharAt(t.length() - 1);
            compute(s, t);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ12919.solution();
    }
}

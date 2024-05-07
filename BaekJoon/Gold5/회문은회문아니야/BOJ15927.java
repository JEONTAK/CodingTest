package BaekJoon.Gold5.회문은회문아니야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15927 {

    static String s;
    static int front, back;
    static boolean flag = false;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        front = 0;
        back = s.length() - 1;
        if (!isPal(front, back)) {
            System.out.println(s.length());
        } else{
            if (s.length() == 1) {
                System.out.println(-1);
            } else if (flag) {
                System.out.println(s.length() - 1);
            } else{
                System.out.println(-1);
            }
        }
    }

    static boolean isPal(int f, int b) {
        while (f < b) {
            if (s.charAt(f) != s.charAt(b)) {
                return false;
            }
            if (s.charAt(f) != s.charAt(f + 1) || s.charAt(b) != s.charAt(b - 1)) {
                flag = true;
            }
            f++;
            b--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ15927.solution();
    }
}

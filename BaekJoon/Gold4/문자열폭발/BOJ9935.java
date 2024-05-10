package BaekJoon.Gold4.문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {

    static String A, B;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        visited = new boolean[B.length()];
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            s.push(A.charAt(i));
            if (s.size() >= B.length()) {
                boolean flag = true;
                for (int j = 0; j < B.length(); j++) {
                    if (s.get(s.size() - B.length() + j) != B.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < B.length(); j++) {
                        s.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : s) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BOJ9935.solution();
    }
}

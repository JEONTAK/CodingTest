package BaekJoon.Gold3.크게만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2812 {

    static int N, K;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int size = N - K;

        Stack<Character> s = new Stack<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (!s.isEmpty()) {
                while (!s.isEmpty() && K > 0 && s.peek() < str.charAt(i)) {
                    s.pop();
                    K--;
                }
            }
            s.push(str.charAt(i));
        }

        while (true) {
            if (s.size() == size) {
                break;
            }
            s.pop();
        }
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb.reverse());
    }

    public static void main(String[] args) throws IOException {
        BOJ2812.solution();
    }
}

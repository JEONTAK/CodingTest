package BaekJoon.Gold5.옥상정원꾸미기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198 {

    static int N;
    static long result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                }else break;
            }
            result += stack.size();
            stack.push(height);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ6198.solution();
    }
}

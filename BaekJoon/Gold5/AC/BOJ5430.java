package BaekJoon.Gold5.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ5430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    private static void solution() throws IOException {

        ArrayDeque<Integer> deque;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[],");
            deque = new ArrayDeque<Integer>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(func,deque);
        }

        System.out.println(sb);
    }

    static void AC(String func, ArrayDeque<Integer> deque) {
        boolean right = true;
        for (char fnc : func.toCharArray()) {
            if (fnc == 'R') {
                right = !right;
                continue;
            }

            if (right) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
            else{
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        printResult(deque, right);
    }

    static void printResult(ArrayDeque<Integer> deque, boolean right) {
        sb.append('[');
        if (deque.size() > 0) {
            if (right) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else{
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }

    public static void main(String[] args) throws IOException {
        BOJ5430.solution();
    }


}

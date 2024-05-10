package BaekJoon.Gold4.DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9019 {

    static int T, A, B;
    static boolean[] visited;
    static String[] command;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            compute();
        }
    }
    static void compute() {
        visited = new boolean[10000];
        command = new String[10000];
        Arrays.fill(command, "");
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        visited[A] = true;
        while (!q.isEmpty() && !visited[B]) {
            int cur = q.poll();
            int D = (2 * cur) % 10000;
            int S = (cur == 0) ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur % 10) * 1000 + cur / 10;
            if (!visited[D]) {
                q.add(D);
                visited[D] = true;
                command[D] = command[cur] + "D";
            }
            if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                command[S] = command[cur] + "S";
            }
            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                command[L] = command[cur] + "L";
            }
            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                command[R] = command[cur] + "R";
            }
        }
        System.out.println(command[B]);
    }
    public static void main(String[] args) throws IOException {
        BOJ9019.solution();
    }
}

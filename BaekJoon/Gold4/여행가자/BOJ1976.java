package BaekJoon.Gold4.여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1976 {

    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] path;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int d = Integer.parseInt(st.nextToken());
                if (d == 1) {
                    list[i].add(j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        path = new int[M];
        for (int i = 0; i < M; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M - 1; i++) {
            if (!compute(path[i], path[i + 1])) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    static boolean compute(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                return true;
            }
            if(visited[cur]) continue;
            visited[cur] = true;
            for (int next : list[cur]) {
                if (!visited[next]) {
                    q.add(next);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ1976.solution();
    }
}
